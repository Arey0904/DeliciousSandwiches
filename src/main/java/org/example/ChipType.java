package org.example;

    public enum ChipType {REGULAR("Regular"), KETTLE("Kettle"), TORTILLA("Tortilla");

        private String name;

        ChipType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


