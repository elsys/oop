#Конструиране на молекули на водата

Based on [Allen B. Downey, The Little Book of Semaphores](http://greenteapress.com/semaphores/LittleBookOfSemaphores.pdf)


## Условие: Building H2O

There are two kinds of threads, oxygen and hydrogen. In order to assemble
these threads into water molecules, we have to create a barrier that makes each
thread wait until a complete molecule is ready to proceed.

As each thread passes the barrier, it should invoke bond. You must guarantee
that all the threads from one molecule invoke bond before any of the threads
from the next molecule do.

In other words:
* If an oxygen thread arrives at the barrier when no hydrogen threads are
present, it has to wait for two hydrogen threads.
* If a hydrogen thread arrives at the barrier when no other threads are
present, it has to wait for an oxygen thread and another hydrogen thread.
We don’t have to worry about matching the threads up explicitly; that is,
the threads do not necessarily know which other threads they are paired up
with. The key is just that threads pass the barrier in complete sets; thus, if we
examine the sequence of threads that invoke bond and divide them into groups
of three, each group should contain one oxygen and two hydrogen threads.

Puzzle: Write synchronization code for oxygen and hydrogen molecules that
enforces these constraints.


## Клас `WaterConstructor`

Класът `WaterConstructor` синхронизира работата на всички `Oxygen` и `Hydrogen` нишки. Когато се създава
обект `Oxygen` или `Hydrogen` му се предава обект `WaterConstructor constructor`, който се грижи да оркестрира
работата на всички обекти.

Класът `WaterConstructor` съдържа и главната функция на приложението. При работата на приложението на случаен 
принцип се избира дали да се създаде обект от типа `Hydrogen` или от типа `Oxygen`, като средно се създават два 
пъти повече `Hydrogen` обекти.

Примерен скелет на класа `WaterConstructor`:

```java
package org.elsys.water;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class WaterConstructor {

	private AtomicBoolean running = new AtomicBoolean(true);
	private ReentrantLock lock = new ReentrantLock();

	private int oxygenCounter = 0;
	private int hydrogenCounter = 0;

	private CyclicBarrier barrier = new CyclicBarrier(3);

	private Semaphore oxygenSemaphore = new Semaphore(0);
	private Semaphore hydrogenSemaphore = new Semaphore(0);

	public void proceedOxygen(Oxygen oxygen) throws Exception {
		// TODO: implement me
	}

	public void proceedHydrogen(Hydrogen hydrogen) throws Exception {
		// TODO: implement me
	}

	public static void main(String[] args) {
		WaterConstructor constructor = new WaterConstructor();
		Random random = new Random();
		int oxygen = 0;
		int hydrogen = 0;

		while (true) {
			if (random.nextInt(3) == 0) {
				Oxygen o = new Oxygen(++oxygen, constructor);
				new Thread(o).start();
			} else {
				Hydrogen h = new Hydrogen(++hydrogen, constructor);
				new Thread(h).start();
			}
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

```

## Клас `Oxygen`

```java
package org.elsys.water;

public class Oxygen extends Atom implements Runnable {

	public Oxygen(int atomId, WaterConstructor constructor) {
		super(atomId, constructor);
	}

	@Override
	public void run() {
		System.out.println(this + " created");
		try {
			getConstructor().proceedOxygen(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Water molecule created with " + this);
	}

	@Override
	public String getFullName() {
		return "Oxygen";
	}
}

```

## Клас `Hydrogen`

```java
package org.elsys.water;

public class Hydrogen extends Atom implements Runnable {

	public Hydrogen(int atomId, WaterConstructor constructor) {
		super(atomId, constructor);
	}

	@Override
	public void run() {
		System.out.println(this + " created");
		try {
			getConstructor().proceedHydrogen(this);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Water molecule created with " + this);
	}

	@Override
	public String getFullName() {
		return "Hydrogen";
	}
}
```

## Примерен изход от приложението

```
Hydrogen-1 created
Oxygen-1 created
Hydrogen-2 created
Hydrogen-2 bonded
Oxygen-1 bonded
Hydrogen-1 bonded
Water molecule created with Hydrogen-1
Water molecule created with Hydrogen-2
Water molecule created with Oxygen-1
Oxygen-2 created
Hydrogen-3 created
Hydrogen-4 created
Hydrogen-4 bonded
Hydrogen-3 bonded
Oxygen-2 bonded
Water molecule created with Oxygen-2
Water molecule created with Hydrogen-3
Water molecule created with Hydrogen-4
Oxygen-3 created
Hydrogen-5 created
Hydrogen-6 created
Hydrogen-6 bonded
Hydrogen-5 bonded
Oxygen-3 bonded
Water molecule created with Oxygen-3
Water molecule created with Hydrogen-5
Water molecule created with Hydrogen-6
Oxygen-4 created
Hydrogen-7 created
Oxygen-5 created
...
```