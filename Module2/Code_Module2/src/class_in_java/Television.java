package class_in_java;

public class Television {
    public static void main(String[] args) {
        TV tv = new TV();
        int channel = tv.channel;
        int volume = tv.volume;
        boolean on =  tv.check;
        tv.turnOn();
        tv.setChannel(12);
        tv.setVolume(6);
        tv.turnOn();

        System.out.println(on);
        System.out.println(channel);
        System.out.println(volume);
    }
}
class TV {
    int channel = 1;
    int volume = 1;
    boolean check = false;
    TV(){
    }
    void turnOn(){
        this.check = true;
        System.out.println("TV is turn on.");
    }
    void turnOff(){
        this.check = false;
        System.out.println("TV is turn off.");
    }
    void setChannel(int newChannel){
        if (check && newChannel >= 1 && newChannel <= 120 ){
            channel = newChannel;
        }
    }
    void setVolume(int newVolume){
        if (check && newVolume >= 1 && newVolume <= 7){
            volume = newVolume;
        }
    }
    void channelUp(){
        if (check && channel < 120){
            channel++;
        }
    }
    void channelDown(){
        if(check && channel > 1){
            channel--;
        }
    }
    void volumeUp(){
        if (check && volume < 7){
            volume++;
        }
    }
    void  volumeDown(){
        if (check && volume > 1){
            volume--;
        }

    }


}
