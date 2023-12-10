package org.siberianhusky.huskycore.utils.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EditFile {
    /**
     * 写入文件
     * @param path 文件路径
     * @param text 写入的文本
     * @param mode 写入模式(0:覆盖写入,1:追加写入)
     * @return 0为文件不存在,1为写入成功,2为写入失败
     */
    public static int write(String path,String text,int mode){
        File file = new File(path);
        if(!file.exists()){
            return 0;
        }
        else {
            try {
                FileWriter writer;
                if (mode == 0) {
                    writer = new FileWriter(file, false);
                } else {
                    writer = new FileWriter(file, true);
                }
                writer.write(text);
                return 1;
            } catch (IOException e) {
                return 2;
            }
        }
    }

    /**
     * 写入文件(覆盖写入)
     * @param path 文件路径
     * @param text 写入的文本
     * @return 0为文件不存在,1为写入成功,2为写入失败
     */
    public static int write(String path,String text){
        return write(path,text,0);
    }
}
