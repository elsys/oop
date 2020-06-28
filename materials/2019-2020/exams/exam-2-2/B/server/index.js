const express = require('express')
const fs = require('fs-extra')
const jpeg = require('jpeg-js');
const _ = require('lodash')
const bodyParser = require('body-parser')
const path = require('path')

const IMG_SRC = './images-source'
const IMG_DEST = './images-result'

let allSrcFiles = fs.readdirSync(IMG_SRC);
console.log("Found files")
console.log(allSrcFiles)

const imageLookup = allSrcFiles.map((fileName) => ({
  fileName,
  segmentSize: 8,
  outputCounter: 0
}))

let currImageIndex = 0

const loadImage = (fileName) => {
  const jpegData = fs.readFileSync(path.join(IMG_SRC, fileName))
  const rawImageData = jpeg.decode(jpegData, {useTArray: true});

  return rawImageData
}

const writeImage = (fileName, data) => {
  let jpegImageData = jpeg.encode(data, 50);
  let splitName = fileName.split('.')
  let imgConfig = imageLookup.find((img) => img.fileName == fileName)
  splitName[0] += '-' + imgConfig.outputCounter++
  console.log(`Save ${fileName} with revision ${imgConfig.outputCounter - 1}`)
  fs.writeFileSync(path.join(IMG_DEST, splitName.join('.')), jpegImageData.data);
}


const serveImage = (req, res, next) => {
  let config = imageLookup[currImageIndex++]
  let imageData = loadImage(config.fileName)

  console.log(`[${req.ip}] Serving image ${config.fileName}`)

  res.json(_.omit({...imageData, name: config.fileName, data: Array.prototype.slice.call(imageData.data)}, ['exifBuffer']))

  if(currImageIndex >= imageLookup.length) currImageIndex = 0
}

const receiveImage = (req, res, next) => {
  console.log(`[${req.ip}] Received image ${req.body.name}`)
  try {
    writeImage(req.body.name, req.body)
    res.status(200).send()
  } catch {
    res.status(500).send()
  }
}

const listImages = (req, res, next) => {
  let allResFiles = fs.readdirSync(IMG_DEST);

  res.json(allResFiles)
}

const app = express()
app.use(bodyParser.json({limit: '50mb', extended: true}))
const port = 3000

app.get('/api/image', serveImage)
app.post('/api/image', receiveImage)
app.get('/api/list', listImages)

app.use(express.static('static'))
app.use(express.static('images-result'))

app.listen(port, () => console.log(`Example app listening at http://localhost:${port}`))
