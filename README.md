# CSC3002 OS Assignment Part III by Mholi Mncube MNCMHO001
08/05/2019

# Aim
This assignment aims to give you experience in thread (and, by extension, process)
synchronization using semaphores. In this project, you will write multithreaded
programs in Java to solve three classic synchronization problems, using only
semaphores. A secondary aim is to give you experience in reading, understanding
and correcting existing code. The assignment is in three parts, increasing in
difficulty. The third part is described below.

Part III: Making methane with semaphores
Methane is a molecule with four hydrogens attached to a single carbon (CH4). For this
project, you will run a simulation of the combination of carbon and hydrogen atoms
into methane molecules.
There are two kinds of atoms (threads), carbon and hydrogen, in your simulations. In
order to assemble these atoms into methane molecules, each atom must wait until the
right number (and type) of atoms are available to bond (by calling the bond()
method) into a complete methane molecule.
There are a number of synchronization constraints on this simulation, as follows.
* Only one methane molecule forms at a time. You must guarantee that all
the atoms from one molecule invoke bond() before any of the atoms from
the next molecule. In other words:
* If a carbon thread arrives at the barrier when no hydrogen threads are present,
it has to wait for four hydrogen threads.
* If a hydrogen thread arrives at the barrier when no other threads are present, it
has to wait for a carbon thread and a further three hydrogen threads. Etc.

# Instructions for running and compling

* Run Terminal/CMD to directory of project
* Make file > to compile the java files
* Type - "java CleaningDishes 6 3 100 100" to run test 
* Alternatively type run/run1 to run test which have input values 6 3 100 100, 4 2 100 100
* Delete .class files make > clean


