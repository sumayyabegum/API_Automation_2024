package Restfull_Booker_API;

public class Restfull_Constant {

        final static String base_url="https://restful-booker.herokuapp.com";
        final static String login_User="/auth";
        final static String get_bookingIds="/booking";
        final static String get_Id_byName="/booking?firstname=Mark&lastname=Jones";
        final static String get_Id_byDate="/booking?checkin=2018-03-02&checkout=2019-05-21";
        final static String get_bookingId="/booking/708";
        final static String create_booking="/booking";
        final static String update_booking="/booking/4";
        final static String partialUpdate_booking="/booking/:id";
        final static String delete_booking="/booking/:id";
        final static String healthCheck="/ping";

    }
