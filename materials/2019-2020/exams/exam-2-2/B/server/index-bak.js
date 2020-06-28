const express = require('express')
const fs = require('fs-extra')
const jpeg = require('jpeg-js');

const app = express()
const port = 3000

const imageLookup = [
  {
    fileName: './images-source/0-2.jpg',
    segmentSize: 8,
    passes: 5
  }
]


const loadImage = (path) => {
  const jpegData = fs.readFileSync(path)
  const rawImageData = jpeg.decode(jpegData, {useTArray: true});

  // console.log(typeof jpegData)
  // console.log(jpegData.length)
  // console.log(jpegData)
  // console.log(rawImageData.width, rawImageData.height, rawImageData.data.length);

  return rawImageData
}

const writeImage = (path, data) => {
  var jpegImageData = jpeg.encode(data, 50);
  fs.writeFileSync(path, jpegImageData.data);
}

const getSegmentedImage = (config)  => {
  const imageData = loadImage(config.fileName)
  let segmentData = {
    segments: [],
    yCount: Math.ceil(imageData.height / config.segmentSize),
    xCount: Math.ceil(imageData.width / config.segmentSize),
    width: imageData.width,
    height: imageData.height,
    segmentSize: config.segmentSize,
  }
  console.log(imageData.data)

  for(let y = 0; y < imageData.height; y += config.segmentSize) {
    for(let x = 0; x < imageData.width; x += config.segmentSize) {
      let realWidth = Math.min(config.segmentSize, imageData.width - x)
      let realHeight = Math.min(config.segmentSize, imageData.height - y)

      let newSegment = {
        width: realWidth,
        height: realHeight,
        key: `${y / config.segmentSize}-${x / config.segmentSize}`,
        data: []
      }
      for(let y2 = 0; y2 < realHeight; y2++) {
        for(let x2 = 0; x2 < realWidth; x2++) {
          for(let i=0; i<4;i++)
          newSegment.data.push(imageData.data[((y + y2) * imageData.width) + ((x + x2) * 4) + i])
        }
      }
      segmentData.segments.push(newSegment)
    }
  }

  return segmentData
}

const buildFromSegments = (segmentData) => {
  let imageData = {
    width: segmentData.width,
    height: segmentData.height,
    // data: new Array(segmentData.width * segmentData.height * 4)
    data: []
  }
  console.log(segmentData)
  console.log(segmentData.segments[0])

  // for(let sy = 0; sy < segmentData.yCount; sy++) {
  //   for(let sx = 0; sx < segmentData.xCount; sx++) {
  //     let seg
  //   }
  // }

  // for(let k = 0; k < segmentData.width * segmentData.height; k++) {
  //   let sy = k / segmentData.segmentSize
  //   let sx = k /
  // }

  for(let sy = 0; sy < segmentData.yCount; sy++) {
    for(let sx = 0; sx < segmentData.xCount; sx++) {
      let segment = segmentData.segments[(sy * segmentData.xCount) + sx]
      for(let y = 0; y < segment.height * 4; y++) {
        for(let x = 0; x < segment.width * 4; x++) {
          // for(let i=0; i < 4; i++) {
            //imageData.data[((sy * segmentData.segmentSize + y * segmentData.width) + (sx * segmentData.segmentSize + x)) * 4 + i] = segment.data[(y * segment.width + x) * 4 + i]
            let segmentIndex = y * segment.width + x
            // let imageIndex = ((sy * segmentData.segmentSize + y * segmentData.width) + (sx * segmentData.segmentSize + x)) * 4 + i
            imageData.data.push(segment.data[segmentIndex])
            // imageData.data[segmentIndex] = segment.data[segmentIndex]
          }
        // }
      }
    }
  }

  // for(let y = 0; y < segmentData.height; y++) {
  //   let sy = Math.floor(y / segmentData.segmentSize)
  //   for(let x = 0; x < segmentData.width; x++) {
  //     let sx = Math.floor(x / segmentData.segmentSize)
  //     let segment = segmentData.segments[(sy * segmentData.xCount) + sx]
  //
  //     console.log((y * segmentData.width + x))
  //     imageData.data[(y * segmentData.width + x) * 4] = segmentData.segments[0].data[0]
  //     imageData.data[(y * segmentData.width + x) * 4 + 1] = segmentData.segments[0].data[1]
  //     imageData.data[(y * segmentData.width + x) * 4 + 2] = segmentData.segments[0].data[2]
  //     imageData.data[(y * segmentData.width + x) * 4 + 3] = segmentData.segments[0].data[3]
  //     // imageData.data[(y * segmentData.width + x) + 1] = segmentData.segments[0].data[1]
  //     // imageData.data[(y * segmentData.width + x) + 2] = segmentData.segments[0].data[2]
  //     // imageData.data[(y * segmentData.width + x) + 3] = segmentData.segments[0].data[3]
  //   }
  // }

  // for(let y = 0; y < segmentData.height; y++) {
  //   for(let x = 0; x < segmentData.width; x++) {
  //     for(let i=0; i<4; i++) {
  //       imageData.data[(y * segmentData.width * 4) + x + i] = 0;
  //     }
  //   }
  // }
  // for(let y = 0; y < segmentData.yCount; y++) {
  //   for(let y2 = 0; y2 < segmentData.segmentSize; y2++) {
  //     for(let x = 0; x < segmentData.xCount; x++) {
  //       for(let x2 = 0; x2 < segmentData.segmentSize; x2++) {
  //         console.log(y, x, y2, x2)
  //         for(let i=0; i<4; i++) {
  //           imageData.data.push(segmentData.segments[(y * segmentData.xCount) + x].data[(y2 * segmentData.segmentSize ) + x2 + i]);
  //         }
  //       }
  //     }
  //   }
  // }

  // for(let y = 0; y < segmentData.yCount; y++) {
  //   for(let x = 0; x < segmentData.xCount; x++) {
  //     let segment = segmentData.segments[y * segmentData.yCount + x]
  //     for(let y2 = 0; y2 < segment.height; y2++) {
  //       for(let x2 = 0; x2 < segment.width; x2++) {
  //         for(let i=0; i<4; i++) {
  //           imageData.data[((y + y2) * imageData.width) + ((x + x2) * 4) + i]
  //         }
  //       }
  //     }
  //   }
  // }

  return imageData
}

let segments = getSegmentedImage(imageLookup[0])

let finalDaa = buildFromSegments(segments)
writeImage('./images-result/0-2.jpg', finalDaa)

// let imageData = loadImage('./images-source/1.jpg')
// for(let i=0; i< imageData.data.length; i++) {
//   imageData.data[(i * 4) + 0] = 0;
// }
// writeImage('./images-result/0.jpg', finalDaa)


//console.log(data.toString())

// app.get('/api/image', (req, res) => {
//
// })
// app.post('/api/image', (req, res) => {
//
// })
//
// app.listen(port, () => console.log(`Example app listening at http://localhost:${port}`))
