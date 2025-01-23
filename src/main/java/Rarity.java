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

    LEGENDARY(){
        @Override
        public String toString() {
            return "Legendary";
        }
    }
}
