package kechengsheji;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Stack;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * 获得文件夹下的文件和处理
 * 这里的路径都是绝对路径
 */
public class FileManage extends JFrame {

	public static void main(String[] args) {
		try {
			String st = getFloder(false);
			if (st != null) {
				System.out.println(st);
				convert(st,"png",getFloder(true));
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), "error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// 弹窗选择文件夹
	// temp为真时选择文件夹，为假时选择文件
	public static String getFloder(boolean temp) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("请选择文件夹");
		//
		fileChooser.setFileSelectionMode(temp ? JFileChooser.DIRECTORIES_ONLY
				: JFileChooser.FILES_ONLY);
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile().getPath();
		} else
			return null;
	}

	// 判断文件夹下的文件，是文件夹或文件就压栈，并返回路径数组
	public static Stack<String> getFileInFolder(String path) {
		try {
			Stack<String> stack = new Stack<String>();
			File fload = new File(path);
			if (fload.isDirectory()) {
				for (String s : fload.list()) {
					File file = new File(path + "\\" + s);
					if (file.exists()
							&& (ImageJudge.IsImage(file)||UnZipFile.JudgeIsZip(file) || file.isDirectory())&&!file.isHidden()) {
						stack.push(path + "\\" + s);
					}
				}
				if (stack.isEmpty()) {
					return null;
				} else {
					return stack;
				}
			} else
				return null;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), "error",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	//获得文件夹下所有东西
	public static Stack<String> getAllInFolder(String path) {
		try {
			Stack<String> stack = new Stack<String>();
			File fload = new File(path);
			if (fload.isDirectory()) {
				for (String s : fload.list()) {
					File file = new File(path + "\\" + s);
					if (file.exists()|| file.isDirectory()) {
						stack.push(path + "\\" + s);
					}
				}
				if (stack.isEmpty()) {
					return null;
				} else {
					return stack;
				}
			} else
				return null;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), "error",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	//获得文件夹下的图片
	public static Stack<String> getImgFileInFolder(String path) {
		try {
			Stack<String> stack = new Stack<String>();
			File fload = new File(path);
			if (fload.isDirectory()) {
				for (String s : fload.list()) {
					File file = new File(path + "\\" + s);
					if (file.exists()&&ImageJudge.IsImage(file)) {
						stack.push(path + "\\" + s);
					}
				}
				if (stack.isEmpty()) {
					return null;
				} else {
					return stack;
				}
			} else
				return null;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), "error",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	//获得文件下的文件夹
	public static Stack<String> getFolderInFolder(String path) {
		try {
			Stack<String> stack = new Stack<String>();
			File fload = new File(path);
			if (fload.isDirectory()) {
				for (String s : fload.list()) {
					File file = new File(path + "\\" + s);
					if (file.exists()&& file.isDirectory()) {
						stack.push(path + "\\" + s);
					}
				}
				if (stack.isEmpty()) {
					return null;
				} else {
					return stack;
				}
			} else
				return null;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.toString(), "error",
					JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}

	public static boolean deleteFile(String path) {
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			return file.delete();
		} else if (file.exists() && file.isDirectory()) {
			System.out.println("file"+path);
			return deleteFload(path);
		} else
			return false;

	}

	// 删除文件夹
	public static boolean deleteFload(String path) {
		File file = new File(path);
		System.out.println("fload"+path);
		// 删除文件夹下的文件
		if (file.exists() && file.isDirectory()) {
			if(getAllInFolder(path)!=null)
			for (String p : getAllInFolder(path)) {
				System.out.println("for"+p);
				deleteFile(p);
			}
			// 删除最后的文件夹自己
			return file.delete();
		} else if (file.exists() && file.isFile()) {
			return deleteFile(path);
		} else
			return false;
	}

	// 文件改名
	// before 是旧文件的路径，
	// after 是文件更改后的名字
	public static String changeName(String before, String after) {
		File oldFile = new File(before);
		if (after == "") {
			return "";
		}
		if (oldFile.exists() &&( oldFile.isFile()||oldFile.isDirectory())) {
			String path = oldFile.getParentFile().getPath();
			// System.out.print("1:"+path+after+"."+getFileType(before));
			File newFile = new File(path + "//" + after + "."
					+ getFileType(before));
			if (newFile.exists()) {
				newFile.delete();
			} 
			oldFile.renameTo(newFile);
			System.out.println(newFile.getPath());
			return newFile.getPath();
		} else
			return "";
	}

	// 获得文件类型
	public static String getFileType(String path) {
		File file = new File(path);
		if (file.exists() && file.isFile()) {
			String fileName = file.getPath();
			if (fileName.lastIndexOf(".") != -1
					&& fileName.lastIndexOf(".") != 0) {
				return fileName.substring(fileName.lastIndexOf(".") + 1);
			} else {
				return "";
			}
		} else {
			return "";
		}
	}

	// 移动文件
	// beforeP文件路径
	// afterP目标文件夹路径
	public static boolean fileRemove(String beforeP, String afterP) {
		File oldFile = new File(beforeP);
		if (oldFile.exists()) {
			File newFile = new File(afterP);
			if (!newFile.exists()) {
				newFile.mkdir();
			}
			oldFile.renameTo(new File(afterP + "//" + oldFile.getName()));
		}
		return true;
	}

	// 复制
	// 源文件
	// 目标路径
	public static boolean fileCopy(String beforeP, String afterP) {
		File oldFile = new File(beforeP);
		if (oldFile.exists()) {
			File newFile = new File(afterP);
			if (!newFile.exists()) {
				newFile.mkdir();
			}
			copyFile2(beforeP, afterP + "//" + oldFile.getName());
		}
		return true;
	}
	//复制文件的核心代码
	private static void copyFile2(String source, String dest) {
		try {
			File in = new File(source);
			File out = new File(dest);
			FileInputStream inFile = new FileInputStream(in);
			FileOutputStream outFile = new FileOutputStream(out);
			byte[] buffer = new byte[10240];
			int i = 0;
			while ((i = inFile.read(buffer)) != -1) {
				outFile.write(buffer, 0, i);
			}// end while
			inFile.close();
			outFile.close();
		}// end try
		catch (Exception e) {

		}// end catch
	}// end copyFile
	
	//图片转码
	//srcImageFile 源文件
	//formatName格式名
	//destimgFile 目标文件夹路径
	public static boolean convert(String srcImageFile, String formatName, String destImageFile) {
        try {
            File f = new File(srcImageFile);
            f.canRead();
            f.canWrite();
            BufferedImage src = ImageIO.read(f);
            String temp=getFileType(f.getName());
            temp=f.getName().replace(temp, "bmp");
            System.out.println(temp);
            String filePath=destImageFile+"//"+f.getName().replace(temp, formatName);
            ImageIO.write(src, formatName, new File(filePath));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
	
}
