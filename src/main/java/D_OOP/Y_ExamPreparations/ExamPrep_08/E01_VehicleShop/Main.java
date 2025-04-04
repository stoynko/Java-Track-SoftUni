package D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop;

import D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.core.Engine;
import D_OOP.Y_ExamPreparations.ExamPrep_08.E01_VehicleShop.core.EngineImpl;

public class Main {

/* You are given interfaces, and you have to implement their functionality in the correct classes.
There are 4 types of entities in the application: Worker, Vehicle, Shop, and Tool.
There should also have been a WorkerRepository, as well as VehicleRepository.

BaseWorker: BaseWorker is a base class or any type of Worker and it should not be able be instantiated.
Data:
    • name – String
        o If the name is null or whitespace, throw an IllegalArgumentException with a message: "Worker name cannot be null or empty."
        o All names will be unique.
    • strength – int
        o The strength of a worker.
        o If the strength is below 0, throw an IllegalArgumentException with a message: "Cannot create a Worker with negative strength.".
    • tools – Collection<Tool>
        o A collection of a worker's tools.
Constructor:
A BaseWorker should take the following values upon initialization: String name, int strength

Behavior:
    • void working(). The working() method decreases workers' strength by 10.
        o A worker's strength should not drop below 0 (If the strength becomes less than 0, set it to 0).
    • void addTool(Tool tool)
        o This method adds a tool to the worker's collection of tools.
    • boolean canWork()
        o This method returns: true - if the current strength of the worker is greater than 0, false - otherwise

Child Classes: There are two types of BaseWorker.
    • FirstShift
        o Initial strength units: 100.
        o The constructor should take the following values upon initialization: String name
    • SecondShift
        o Initial strength units: 70.
        o The method working() decreases the workers' strength by additional 5 units.
        o The constructor should take the following values upon initialization: String name

ToolImpl: The ToolImpl is a class that represents the tool, which a Workers uses to make Vehicle. It should be able to be instantiated.
Data:
    • power – int
        o The power of a tool.
        o If the initial power is below 0, throw an IllegalArgumentException with a message: "Cannot create a Tool with negative power.".
Constructor:
    • A ToolImpl should take the following values upon initialization: int power
Behavior:
    • void decreasesPower(). The decreasesPower() method decreases the tool's power by 5.
        o A tool's power should not drop below 0. (If the power becomes less than 0, set it to 0).
    • boolean isUnfit()
        o This method returns: true – when power becomes equal to 0, false - otherwise.

VehicleImpl: This is the class that holds information about the Vehicle that a Worker is working on. It should be able to be instantiated.
Data:
    • name - String
        o If the name is null or whitespace, throw an IllegalArgumentException with a message: "Vehicle name cannot be null or empty.".
    • strengthRequired – int
        o The strength required to make the vehicle.
        o If the initial strength is below 0, throw an IllegalArgumentException with a message: "Cannot create a Vehicle requiring negative strength.".
Constructor:
    • A VehicleImpl should take the following values upon initialization: String name, int strengthRequired
Behavior:
    • void making(). The making() decreases the required strength of the vehicle by 5 units.
        o A vehicle's required strength should not drop below 0.
        o If the strength becomes less than 0, set it to 0.
    • boolean reached()
        o The reached() method returns true if the strengthRequired reaches 0.

ShopImpl: Create a ShopImpl class. The ShopImpl class holds the main action, which is the make method.
Behavior:
    • void make(Vehicle vehicle, Worker worker)
        o The worker starts making the vehicle. This is only possible if the worker has strength and a tool that isn't broken.
        o Keep working until the vehicle is done or the worker has strength (and tools to use).
        o If at some point the power of the current tool reaches or drops below 0, meaning it is broken, then the worker should take the next tool from its collection, if it has any left.

WorkerRepository: The worker repository is a repository for the worker working at Vehicle’s Shop.
Data:
    • workers – a collection of workers
Behavior:
    • void add(Worker worker)
        o Adds a worker to the collection.
        o There will be no workers of the same name.
    • boolean remove(Worker worker)
        o Removes a worker from the collection.
        o Returns true if the deletion was successful.
    • Worker findByName(String name)
        o Returns a worker with that name if such exists. If it doesn't exist - return null.
    • Collection<Worker> getWorkers()
        o Returns a collection of workers (unmodifiable).

VehicleRepository: The vehicle repository is a repository for vehicles that await to be made.
Data:
    • vehicles – a collection of vehicles.
Behavior
    • void add(Vehicle vehicle)
        o Adds a vehicle to be making.
        o There will be no vehicle of the same name.
    • boolean remove(Vehicle vehicle)
        o Removes a vehicle from the collection.
        o Returns true if the deletion was successful.
    • Vehicle findByName(String name)
        o Returns a vehicle with that name if such exists.
        o It is guaranteed that the vehicle exists in the collection.
    • Collection<Vehicle> getWorkers()
        o Returns a collection of workers (unmodifiable).


The Controller Class
The business logic of the program should be concentrated around several commands. You are given interfaces, which you have to implement in the correct classes.
Note: The ControllerImpl class SHOULD NOT handle exceptions! The tests are designed to expect exceptions, not messages!
The first interface is Controller. You must create a ControllerImpl class, which implements the interface and implements all its methods.
The constructor of ControllerImpl does not take any arguments. The given methods should have the following logic:

Commands: There are several commands, which control the business logic of the application. They are stated below.

    • AddWorker Command (type – String, workerName – String)
        o Creates a worker with the given name of the given type.
        o If the worker is invalid (the type is not FirstShift or SecondShift), throw an IllegalArgumentException with the message: "Worker type doesn't exist."
        o The method should return the following message if the worker has been added to the repository: "Successfully added {workerType} with name {workerName}."

	• AddVehicle Command (vehicleName - String, strengthRequired – int)
        o Creates a vehicle with the provided name and required strength and adds it to the corresponding repository.
        o The method should return the following message: "Successfully added Vehicle: {vehicleName}."

	• AddToolToWorker Command (workerName – String, power – int)
        o Creates a tool with the given power and adds it to the collection of the worker.
        o If the worker doesn't exist in the worker repository, throw an IllegalArgumentException with the message: "The worker doesn't exist. You cannot add a tool."
        o The method should return the following message if the tool has been added to the worker: "Successfully added tool with power {toolPower} to worker {workerName}."

	• MakingVehicle Command (vehicleName – String)
        o When the making command is called, the action happens.
        o You should start making the given vehicle, by assigning workers which are almost ready:
			- The workers that you should select are the ones with strength above 70 units.
			- The suitable ones start working on the given vehicle.
			- If no workers are ready, throw IllegalArgumentException with the following message:  "There is no worker ready to start making."
        o After the work is done, you must return the following message, reporting whether the vehicle is done and how many total tools were unfit in the process:
		  "Vehicle {vehicleName} is {done/not done}. {countBrokenTools} tool/s have been unfit while working on it!"
		  Note: The name of the vehicle you receive will always be a valid one.

	• Statistics Command:
        o Returns information about making vehicles and workers:
			"{countMadeVehicle} vehicles are ready!
			Info for workers:
			Name: {workerName1}, Strength: {workerStrength1}
			Tools: {countTools} fit left"
			…
			"Name: {workerNameN}, Strength: {workerStrengthN}
			Tools: {countTools} fit left"
	• Exit Command
        o Ends the program.

Input / Output:
You are provided with one interface, which will help you with the correct execution process of your program.
The interface is Engine and the class implementing this interface should read the input and when the program finishes, this class should print the output.

Input: Below, you can see the format in which each command will be given in the input.
    • AddWorker {workerType} {workerName}
    • AddVehicle {vehicleName} {strengthRequired}
    • AddToolToWorker {workerName} {power}
    • MakingVehicle {vehicleName}
    • Statistics
    • Exit */

    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
