package ch.heigvd.res.stpatrick;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

import org.apache.commons.lang3.StringUtils;
/**
 * 
 * @author Tony Clavien
 */
public class IStreamADecorator implements IStreamDecoratorController{

	@Override
	public Reader decorateReader(Reader inputReader) {
		return inputReader;
	}

	@Override
	public Writer decorateWriter(Writer outputWriter) {
		Writer a = new Writer() {
			
			@Override
			public void write(char[] cbuf, int off, int len) throws IOException {
				// TODO Auto-generated method stub
				String newS = String.valueOf(cbuf);
				String withoutA = StringUtils.replaceChars(newS, "aA", "");
				outputWriter.write(withoutA.toCharArray(), off, len);
			}
			
			
			@Override
			public void flush() throws IOException {
				// TODO Auto-generated method stub
				outputWriter.flush();
			}
			
			@Override
			public void close() throws IOException {
				// TODO Auto-generated method stub
				outputWriter.close();
			}
		};
		return a;
	}

}
