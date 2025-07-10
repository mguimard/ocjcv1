package training.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		File f = new File("/tmp/demo");
		File f2 = new File("/tmp/demo2");

		try(FileInputStream is = new FileInputStream(f)){

			int i;
			while((i = is.read()) != -1) {
				System.out.println(i);
			}

			// is.close()
		}

		try(DataInputStream dis = new DataInputStream(new FileInputStream(f))){
			byte[] bytes = dis.readAllBytes();
			String s = new String(bytes);
			System.out.println(s);
		}

		try(FileOutputStream fos = new FileOutputStream(f)){
			String s = "Java";
			fos.write(s.getBytes());
		}

		try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(f2))){		
			// 32 bits signé
			// 0000 0000 0000 0000 0000 0000 0000 0001
			dos.writeInt(1);
			dos.writeDouble(0.123456789f);
			dos.writeBytes("hello world");
		}


		try(DataInputStream dis = new DataInputStream(new FileInputStream(f2))){
			int b = dis.readByte();
			System.out.println(b);
			b = dis.readByte();
			System.out.println(b);
			b = dis.readByte();
			System.out.println(b);
			b = dis.readByte();
			System.out.println(b);

			double x = dis.readDouble();
			System.out.println(x);

			String s = new String(dis.readAllBytes());
			System.out.println(s);

			int nextInt = dis.read();
			System.out.println(nextInt);
			nextInt = dis.read();
			System.out.println(nextInt);
		}

		
		FileInputStream is = null;
		
		try {
			is = new FileInputStream(f);
			/// 
			///
		} catch(IOException e) {
			
		}
		finally {
			if(is != null) {
				is.close();
			}
		}
		
		

		System.out.println("Fin de programme");
	}

}
