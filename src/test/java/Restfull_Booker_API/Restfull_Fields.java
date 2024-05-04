package Restfull_Booker_API;

public class Restfull_Fields {
        /**{
         "username" : "admin",
         "password" : "password123"
         }
         {
         "firstname" : "Jim",
         "lastname" : "Brown",
         "totalprice" : 111,
         "depositpaid" : true,
         "bookingdates" : {
         "checkin" : "2018-01-01",
         "checkout" : "2019-01-01"
         },
         "additionalneeds" : "Breakfast"
         }'
         */


        private String firstname;
        private String lastname;
        private int totalprice;
        private boolean depositpaid;
        private String bookingdates;
        private String checkin;
        private String checkout;
        private String additionalneeds;



        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public int getTotalprice() {
            return totalprice;
        }

        public void setTotalprice(int totalprice) {
            this.totalprice = totalprice;
        }

        public boolean isDepositpaid() {
            return depositpaid;
        }

        public void setDepositpaid(boolean depositpaid) {
            this.depositpaid = depositpaid;
        }

        public String getBookingdates() {
            return bookingdates;
        }

        public void setBookingdates(String bookingdates) {
            this.bookingdates = bookingdates;
        }

        public String getCheckin() {
            return checkin;
        }

        public void setCheckin(String checkin) {
            this.checkin = checkin;
        }

        public String getCheckout() {
            return checkout;
        }

        public void setCheckout(String checkout) {
            this.checkout = checkout;
        }

        public String getAdditionalneeds() {
            return additionalneeds;
        }

        public void setAdditionalneeds(String additionalneeds) {
            this.additionalneeds = additionalneeds;
        }

    }
