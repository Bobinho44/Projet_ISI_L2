/**
 * 
 * Copyright (C) 2017 Emmanuel DESMONTILS
 * 
 * This library is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 * 
 * 
 * 
 * E-mail:
 * Emmanuel.Desmontils@univ-nantes.fr
 * 
 * 
 **/

/**
 * JFSM.java
 *
 *
 * Created: 2017-08-25
 *
 * @author Emmanuel Desmontils
 * @version 1.0
 */

package JFSM;
import java.util.Set;
import java.util.HashSet;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class JFSM {
    public static void main(String argv []) throws JFSMException {

      Set<String> A = new HashSet<String>();      
      A.add("a");A.add("b");A.add("c");

      Set<Etat> Q = new HashSet<Etat>();
      Q.add(new Etat("1"));Q.add(new Etat("2"));
      Q.add(new Etat("3"));Q.add(new Etat("4"));Q.add(new Etat("5"));

      Set<Transition> mu = new HashSet<Transition>();
      mu.add(new Transition("1","a","2"));
      mu.add(new Transition("1","b","4"));
      mu.add(new Transition("2","b","3"));
      mu.add(new Transition("2","c","4"));
      mu.add(new Transition("3","a","2"));
      mu.add(new Transition("3","b","4"));
      mu.add(new Transition("4","a","5"));
      mu.add(new Transition("5","c","5"));


      Set<String> F = new HashSet<String>();
      F.add("5");
      F.add("4");
      F.add("1");
      Automate afn = new AFD(A, Q, "1", F, mu);

      Set<String> A2 = new HashSet<String>();      
      A2.add("a");A2.add("b");A2.add("c");

      Set<Etat> Q2 = new HashSet<Etat>();
      Q2.add(new Etat("q6"));Q2.add(new Etat("q3"));
      Q2.add(new Etat("q2"));Q2.add(new Etat("q5"));

      Set<Transition> mu2 = new HashSet<Transition>();
      mu2.add(new Transition("q6","b","q5"));
      mu2.add(new Transition("q5","a","q2"));
      mu2.add(new Transition("q2","b","q2"));
      mu2.add(new Transition("q2","c","q3"));
      mu2.add(new Transition("q3","c","q3"));
      mu2.add(new Transition("q3","a","q6"));


      Set<String> F2 = new HashSet<String>();
      F2.add("q5");
      F2.add("q2");
      F2.add("q3");
      Automate Asecond = new AFD(A2, Q2, "q6", F2, mu2);
        
        Automate test = afn.intersection(Asecond);
        System.out.println("Transition " + test.mu);
        System.out.println("Alphabet " + test.A);
        System.out.println("Q " + test.Q);
        System.out.println("F " + test.F);
        System.out.println("Initial " + test.I);
        

       
      
        
   }

}
