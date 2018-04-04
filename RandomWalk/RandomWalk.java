package Assignment1;

import java.util.Random;
public class RandomWalk {
    private int x = 0;
    private int y = 0;
    private final Random random = new Random();

    public void move(int dx, int dy) {
      this.x+=dx;
      this.y+=dy;
       
    }
    
    private void randomWalk(int n) {
       for (int i = 0; i < n; i++)
           randomMove();
    }

    
    private void randomMove() {
        int flag = (int)Math.floor(Math.random()*4);
        switch(flag){
        case 0: this.x++;break;
        case 1: this.x--;break;
        case 2: this.y++;break;
        case 3: this.y--;break;
        }
    }

    public double distance() {
        return Math.sqrt(Math.pow(x, 2)+Math.pow(y,2));
    }

    public static void main(String[] args) {
    	 RandomWalk walk = new RandomWalk();
    	int[] list = {1,2,4,8,16,32,64,128,256,512};
    	for(Integer i : list){
    		 int n = i;
    		 int f =0;
    		 double sum=0.0;
    		 while(f<100000){
    			 walk.randomWalk(n);
    			 sum+= walk.distance();
    			 walk.x=walk.y=0;
    			 f++;
    		 }
    		 System.out.println(n+": "+(double)sum/100000+" "+Math.sqrt(n));
    	}

    }
}
