package decorate.iodemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//iotest包介绍了io流中的各个类充分利用了装饰模式，下面简单实用一下io做一些文件读取上传操作
public class IoTest {

	public static void main(String[] args) throws IOException {
		String sfile = "d:";
		File file = new File(sfile);
		FileInputStream stream = new FileInputStream(sfile);
	}
}
