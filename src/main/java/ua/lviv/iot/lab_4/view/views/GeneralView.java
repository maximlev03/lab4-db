package ua.lviv.iot.lab_4.view.views;

import ua.lviv.iot.lab_4.model.IWithId;
import ua.lviv.iot.lab_4.view.View;

public class GeneralView extends AbstractView<IWithId> implements View<IWithId> {

    public GeneralView() {
        super(new String[]{"Users", "Objects", "Devices", "Rooms", "Roles", "Zones", "Addresses"});
        methodsMenu.put("1", () -> new UserView().show());
        methodsMenu.put("2", () -> new ObjectView().show());
        methodsMenu.put("3", () -> new DeviceView().show());
        methodsMenu.put("4", () -> new RoomView().show());
        methodsMenu.put("5", () -> new RoleView().show());
        methodsMenu.put("6", () -> new ZoneView().show());
        methodsMenu.put("7", () -> new AddressView().show());
    }

    @Override
    protected void addNewObject() {
    }

    @Override
    protected void updateObject() {
    }
}
