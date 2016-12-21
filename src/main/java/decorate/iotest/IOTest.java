package decorate.iotest;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//IO包下的各个类与装饰模式有不接之缘，我们详细了解一下
public class IOTest {

	public static void main(String[] args) throws IOException {
		final String path = "F://text.txt";
		/*
		  InputStream相当于被装饰的接口或者是抽象类，FileInputStream相当于待装饰的原始对象
		  FileInputStream是以只读形式打开一个文件，并打开了一个文件的句柄存放在FileDescriptor对象的handle属性
		  FileInputStream没有重写InputStream的mark和reset方法
		    以下有关回退和重新标记等操作，都是在堆中建立缓冲区所造成的假象，并不是真正的文件流回退和标记
		*/
		InputStream inputStream = new FileInputStream(path);
		//流的长度
		final int length = inputStream.available();
		System.out.println("FileInputStream不支持mark/reset:"+inputStream.markSupported());
		System.out.println("----------------------------------------");
		
		/*下面介绍一下BufferedInputStream,DataInputStream,PushbackInputStream对InputStream的装饰*/
		
		//1.BufferedInputStream，它提供了mark和reset
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		System.out.println("BufferedInputStream支持mark/reset:"+bis.markSupported());
		//标记一下
		bis.mark(0);
		char c = (char)bis.read();
		System.out.println("第一个字符:"+c);
		//重置一下,如果没有重置，则再次调用read时将读取下一个字符
		bis.reset();
		c = (char)bis.read();
		System.out.println("重置以后在读，依然是第一个字符："+c);
		bis.reset();
		
		System.out.println("----------------------------------------");
		
		//装饰城DataInputStream,我们为使用DataInputStream、BufferedInputStream的mark和reset功能，
		//使用DataInputStream包装BufferedInputStream;如果不用BufferedInputStream使用InputStream，read返回的结果-1
		//表示已经读取完毕；BufferedInputStream已经将文件读取完毕，并缓存到了堆上默认缓冲区大小8192B
		DataInputStream dis = new DataInputStream(bis);
		//这个是BufferedInputStream提供的功能，不使用BufferedInputStream的话会报错
		dis.reset();
		int readInt = dis.readInt();
	}
}
