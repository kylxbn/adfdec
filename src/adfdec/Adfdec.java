/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package adfdec;

import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tar Shoduze
 */
public class Adfdec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Console cs = System.console();
        if (cs == null) {
            System.err.println("KONSO-RU ga nai.");
            System.exit(1);
        }
        
        System.out.println("Input path+file: ");
        String i = cs.readLine();
        FileInputStream in;
        in = new FileInputStream(i);
        
        System.out.println("Output path+file: ");
        String of = cs.readLine();
        FileOutputStream o;
        o = new FileOutputStream(of);
        
        System.out.println("\tGTA ADF: 34");
        System.out.println("Mask: ");
        int mask = Integer.valueOf(cs.readLine());
        
        int c;
        boolean x = true;
        boolean con = true;
        byte[] b = new byte[65536];
        do {
            c = in.read(b);
            if (c<65536) con = false;
            for (int bc=0; bc<65536; bc++) b[bc] ^= mask;
            if (con) {
                o.write(b);
            }
            else o.write(b,0,c);
        } while (con);
    }
    
}
