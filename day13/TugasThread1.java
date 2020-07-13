class Thread1 extends Thread {
    public void run() {  
        for(int i = 1; i <= 10; i++){  
            try {
                Thread.sleep(300);
            } catch(InterruptedException e) {
                System.out.println(e);
            }  
            System.out.println("Selamat Datang");  
        }  
    } 
}

class Thread2 extends Thread {
    public void run() {  
        for(int i = 1; i <= 5; i++){  
            try {
                Thread.sleep(600);
            } catch(InterruptedException e) {
                System.out.println(e);
            }  
            System.out.println("Halo Java");  
        }  
    } 
}

class Thread3 extends Thread {
    public void run() {  
        System.out.println("Halo Java");    
    } 
}


public class TugasThread1 {  
     

    public static void main(String args[]) {  
        Thread1 t1 = new Thread1();  
        Thread2 t2 = new Thread2();  
        Thread3 t3 = new Thread3(); 
   
        t1.start();  
        t2.start();  
        t3.start();  
    }  
}