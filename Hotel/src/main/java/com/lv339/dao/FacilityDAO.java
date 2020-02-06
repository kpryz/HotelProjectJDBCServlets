/*
 *
 * Author: Kostiantyn Pryzyhlei
 *
 * Date: 14.08.2018
 *
 */

package com.lv339.dao;

import com.lv339.entity.Facility;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacilityDAO {
    private static Logger logger = Logger.getLogger(FacilityDAO.class.getName());

    /**
     * @param facility
     * @param roomId
     */
    public boolean insertFacility(Facility facility, int roomId) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "INSERT INTO facility(room_id, facility, facilityCategory) VALUES (?, ?, ?)";
            pstm = connection.prepareStatement(sql);

            pstm.setInt(1, roomId);
            pstm.setString(2, facility.getFacility());
            pstm.setString(3, facility.getFacilityCategory());

            pstm.executeUpdate();
        } catch (SQLException e) {
            logger.error("Problem with inserting facility in the database.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement resource in inserting facility method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

    /**
     * @param roomId
     * @return list of facilities
     */
    public List<Facility> getFacilityListByRoomId(int roomId) {
        List<Facility> facilityList = new ArrayList<>();
        PreparedStatement pstmCustomers = null;
        ResultSet rsFacilities = null;

        Connection connection = DBConnection.getInstance().getConnection();

        try {
            String sqlSelectFacilities = "SELECT id, facility, facilityCategory, room_id FROM facility WHERE room_id = ?";

            pstmCustomers = connection.prepareStatement(sqlSelectFacilities);
            pstmCustomers.setInt(1, roomId);

            rsFacilities = pstmCustomers.executeQuery();
            while (rsFacilities.next()) {
                facilityList.add(new Facility(
                        rsFacilities.getInt("id"),
                        rsFacilities.getString("facility"),
                        rsFacilities.getString("facilityCategory"),
                        rsFacilities.getInt("roomId")
                ));
            }
        } catch (SQLException e) {
            logger.error("Problem with getting list of facilities by room id");
            logger.error(e);
        } finally {
            try {
                if (pstmCustomers != null) {
                    pstmCustomers.close();
                }
                if (rsFacilities != null) {
                    rsFacilities.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement or resultSet " +
                             "resources in getting facility list method");
                logger.error(e);
            }
        }

        return facilityList;
    }

    /**
     * @param id
     * @return facility
     */
    public Facility getFacility(int id) {
        Facility facility = new Facility();

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT id, facility, facilityCategory FROM facility WHERE id = ?";
            pstm = connection.prepareStatement(sql);
            pstm.setInt(1, id);

            rs = pstm.executeQuery();

            if (rs.next()) {
                facility.setId(id);
                facility.setFacility(rs.getString("facility"));
                facility.setFacilityCategory(rs.getString("facilityCategory"));
            }
        } catch (SQLException e) {
            logger.error("Problem with getting facility by id from database");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement or resultSet" +
                             " resources in getting facility method");
                logger.error(e);
            }
        }
        return facility;
    }

    /**
     * @param facility
     * @return success
     */
    public boolean updateFacility(Facility facility) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "UPDATE facility SET facility = ?, facilityCategory = ? WHERE id = ?";
            pstm = connection.prepareStatement(sql);

            pstm.setString(1, facility.getFacility());
            pstm.setString(2, facility.getFacilityCategory());
            pstm.setInt(3, facility.getId());

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Something wrong with updating facility in db.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement " +
                             "resource in updating facility method");
                logger.error(e);
            }
        }
        return isSuccess;
    }

    /**
     * @param facilityId
     * @return success
     */
    public boolean deleteFacility(int facilityId) {
        boolean isSuccess = false;

        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pstm = null;
        try {
            String sql = "DELETE FROM user WHERE id = ?";
            pstm = connection.prepareStatement(sql);

            pstm.setInt(1, facilityId);

            isSuccess = pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            logger.error("Problem with deleting facility from database.");
            logger.error(e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                logger.error("Problem with closing preparedStatement" +
                             " resource in deleting facility method");
                logger.error(e);
            }
        }

        return isSuccess;
    }

}
