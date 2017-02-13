package proxyfactory.factorymethod;

public interface Factory {

	UserService createUser();
	IDepartment createDepartment();
}
