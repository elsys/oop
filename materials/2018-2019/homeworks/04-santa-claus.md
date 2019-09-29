# Да синхронизираме Дядо Коледа

Задачата е базирана на *The Santa Claus problem*, от книгата [Allen B. Downey, The Little Book of Semaphores](http://www.greenteapress.com/semaphores/downey08semaphores.pdf).

По подробно обяснение на условието можете да видите в [следното видео](https://www.youtube.com/watch?v=pqO6tKN2lc4)

## Условие

This problem is from William Stallings’s Operating Systems, but he attributes it to John Trono of St. Michael’s College in Vermont.

Santa Claus sleeps in his shop at the North Pole and can only be
awakened by either:

(1) all nine reindeer being back from their vacation in the South Pacific, or 

(2) some of the elves having difficulty
making toys; 

To allow Santa to get some sleep, the elves can only
wake him when three of them have problems. When three elves are
having their problems solved, any other elves wishing to visit Santa
must wait for those elves to return. 

If Santa wakes up to find three
elves waiting at his shop’s door, along with the last reindeer having
come back from the tropics, Santa has decided that the elves can
wait until after Christmas, because it is more important to get his
sleigh ready. (It is assumed that the reindeer do not want to leave
the tropics, and therefore they stay there until the last possible moment.) 

The last reindeer to arrive must get Santa while the others
wait in a warming hut before being harnessed to the sleigh.

Here are some addition specifications:
* After the ninth reindeer arrives, Santa must invoke prepareSleigh, and
then all nine reindeer must invoke getHitched.

* After the third elf arrives, Santa must invoke helpElves. Concurrently,
all three elves should invoke getHelp.
* All three elves must invoke getHelp before any additional elves enter
(increment the elf counter).

Santa should run in a loop so he can help many sets of elves. We can assume
that there are exactly 9 reindeer, but there may be any number of elves.

## Срок на домашното: 02.06.2019 20:00
