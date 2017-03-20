package ch.heigvd.res.stpatrick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * @author Tony Clavien
 * 
 * Remove e from the stream
 *
 */
public class EStreamProcessor implements IStreamProcessor{

	@Override
	public void process(Reader in, Writer out) throws IOException {
	    BufferedReader br = new BufferedReader(in);
	    BufferedWriter bw = new BufferedWriter(out);
	    int c = br.read();
	    bw.write(c);
	    while (c != -1) {
	      c = br.read();
	      if(c != -1 && 
	    		  c != 'e' &&
	    		  c != 'E')
	      {
	    	  bw.write(c);
	      }
	    }
	    bw.flush();
	}

}
