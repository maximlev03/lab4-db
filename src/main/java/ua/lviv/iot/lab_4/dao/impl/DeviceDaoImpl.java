package ua.lviv.iot.lab_4.dao.impl;

import ua.lviv.iot.lab_4.dao.AbstractGeneralDao;
import ua.lviv.iot.lab_4.model.Device;
import ua.lviv.iot.lab_4.model.DeviceType;
import ua.lviv.iot.lab_4.model.Room;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// working
public class DeviceDaoImpl extends AbstractGeneralDao<Device> {

    public DeviceDaoImpl() {
        super("device");
    }

    @Override
    protected String createSqlForSaving() {
        return "insert into " + nameOfTable + "(room_id, model, placing_id, battery_charge, type_id) values (?,?,?,?,?)";
    }

    @Override
    protected void preparePreparedStatementForSaving(PreparedStatement statement, Device device) {
        try {
            statement.setInt(1, device.getRoom().getId());
            statement.setInt(2, device.getModel());
            statement.setInt(3, device.getPlacingId());
            statement.setInt(4, device.getBatteryCharge());
            statement.setInt(5, device.getDeviceType().getId());
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected Device createObjectFromResultSet(ResultSet rs) {
        Device device = new Device();
        try {
            device.setId(rs.getInt(1));
            device.setPlacingId(rs.getInt("placing_id"));
            device.setBatteryCharge(rs.getInt("battery_charge"));
            device.setModel(rs.getInt("model"));
            DeviceType deviceType = new DeviceType();
            deviceType.setId(rs.getInt("type_id"));
            device.setDeviceType(deviceType);
            Room room = new Room();
            room.setId(rs.getInt("room_id"));
            device.setRoom(room);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return device;
    }


    @Override
    protected void preparePreparedStatementForUpdating(PreparedStatement stmt, Device device, int id) {
        preparePreparedStatementForSaving(stmt, device);
        try {
            stmt.setInt(6, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected String createSqlForUpdating() {
        return "update " + nameOfTable + " set room_id=?, model=?, placing_id=?, battery_charge=?, type_id=? where id=?";
    }
}
