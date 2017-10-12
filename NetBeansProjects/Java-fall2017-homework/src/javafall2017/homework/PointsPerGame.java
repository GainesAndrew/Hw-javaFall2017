package javafall2017.homework;

// Programer: Andrew Gaines

public class PointsPerGame implements Points {
    String player;
    int ppg; 
    
    public PointsPerGame(String _player,int _ppg) {
         player = _player;
        ppg = _ppg;
    }
    
    @Override
    public void action() {
        System.out.println("Player: " + player +" ppg = "+ ppg);
    }
    
    @Override
    public String description() {
        return ("Player: " + player +" ppg = "+ ppg);
    }

    @Override
    public int compareTo(Points to) {
        if (to instanceof PointsPerGame) {
            PointsPerGame relay = (PointsPerGame) to;
            if (ppg < relay.ppg) return  -1;
            if (ppg > relay.ppg) return   1;
        
            return 0;
        } else {
            return this.getClass().getName().compareTo(to.getClass().getName());
        }
    }
    
    @Override 
    public boolean equals(Object o) {
        return compareTo((Points) o) == 0;
    }
}