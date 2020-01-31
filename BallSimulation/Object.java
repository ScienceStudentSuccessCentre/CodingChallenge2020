public class Object {
        private double x_axis;
        private double y_axis;
        private double horizontalVelocity;
        private double verticalVelocity;

        public Object(){
            this.x_axis = 0;
            this.y_axis = 0;
            this.horizontalVelocity = 0;
            this.verticalVelocity = 0;
        }

        public Object(double initHeight, double horizontalVelocity, double verticalVelocity){
            this.y_axis = initHeight;
            this.horizontalVelocity = horizontalVelocity;
            this.verticalVelocity = verticalVelocity;
        }

        public double getPositionX() {
            return x_axis;
        }

        public double getPositionY() {
            return y_axis;
        }

        public void update(double division){
            x_axis += horizontalVelocity * division;
            y_axis += verticalVelocity * division;
            verticalVelocity += -9.81 * division;
        }
}
