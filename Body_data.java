public class Body_data {

    private int sexy;
    private double tall;
    private double weight;

    public Body_data(int sexy, double tall, double weight){
        this.sexy = sexy;
        this.tall = tall;
        this.weight = weight;
    }

    public boolean isstrand(){
        double std_m_w = 0.7*(tall - 80);
        double std_w_w = 0.6*(tall - 70);

        if (sexy == 0){
            if (weight < std_m_w)return false;
        }else {
            if (weight < std_w_w)return false;
        }
        return true;
    }
}
