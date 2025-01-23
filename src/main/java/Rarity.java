public enum Rarity {
    COMMON(){
        @Override
        public String toString() {
            return "Common";
        }
    },
    GREAT(){
        @Override
        public String toString() {
            return "Great";
        }
    },
    RARE(){
        @Override
        public String toString() {
            return "Rare";
        }
    },
    EPIC(){
        @Override
        public String toString() {
            return "Epic";
        }
    },
    EPIC1(){
        @Override
        public String toString() {
            return "Epic 1";
        }
    },
    EPIC2(){
        @Override
        public String toString() {
            return "Epic 2";
        }
    },
    LEGENDARY(){
        @Override
        public String toString() {
            return "Legendary";
        }
    }
}
