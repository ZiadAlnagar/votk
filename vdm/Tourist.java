package vdm;

public class Tourist {
        private String Name;
        private String PreferedLanguage;
        private boolean Paid;

        public Tourist(String Name, String PreferedLanguage) {
                this.Name = Name;
                this.PreferedLanguage = PreferedLanguage;
                this.Paid = false;
        }

        public Tourist(String Name, String PreferedLanguage, boolean Paid) {
                this.Name = Name;
                this.PreferedLanguage = PreferedLanguage;
                this.Paid = Paid;
        }

        public boolean isPaid() {
                return this.Paid;
        }

}
