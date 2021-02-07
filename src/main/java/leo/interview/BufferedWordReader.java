package leo.interview;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferedWordReader {

        public static void main(String[] args) {
            BufferedWordReader bwr = new BufferedWordReader("D:\\git\\my.txt");
            String word = bwr.readWord();
            while(word != null) {
                System.out.println(word);
                word = bwr.readWord();
            }
        }

        RandomAccessFile aFile = null;
        FileChannel fileChannel = null;
        ByteBuffer buffer = ByteBuffer.allocate(1);

        public String readWord() {
            try {
                int read = fileChannel.read(buffer);
                StringBuilder sb = new StringBuilder();
                while (read != -1) {
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        char c = (char) buffer.get();
                        if (c != ' ' && c != '\n') {
                            sb.append(c);
                        } else {
                            buffer.compact();
                            return sb.toString();
                        }
                    }
                    buffer.compact();
                    read = fileChannel.read(buffer);
                }
                if (read == -1) {
                    aFile.close();
                }
            } catch (Exception e) {

            }
            return null;
        }

        public BufferedWordReader(String filePath) {
            try {
                aFile = new RandomAccessFile(filePath, "rw");
                fileChannel = aFile.getChannel();
            } catch(Exception e) {

            }
        }

}