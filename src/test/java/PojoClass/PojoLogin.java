package PojoClass;

public class PojoLogin {
    public void setEmail(String email) {
            this.email = email;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        /**
         * {
         *     "email": "timmer@fake.com",
         *     "password": "myPassword"
         * }
         */
        private String email;
        private String password;

    }
