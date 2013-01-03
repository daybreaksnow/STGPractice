package example.stg;

import java.awt.Image;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageManager {
	private static ImageManager instance;
	private static final String PATH = "image" + File.separator;
	private static final String SUFFIX = ".png";

	private Map<String, Image> images = new HashMap<String, Image>();

	private ImageManager() {
	}

	public static ImageManager getInstance() {
		if (instance == null) {
			synchronized (ImageManager.class) {
				if (instance == null) {
					instance = new ImageManager();
				}
			}
		}
		return instance;
	}

	public Image get(String id) {
		if (images.containsKey(id)) {
			return images.get(id);
		} else {
			throw new IllegalArgumentException(id + " is not loaded");
		}
	}

	public void load(String id) {
		String path = PATH + id + SUFFIX;
		File file = new File(path);
		if (!file.exists()) {
			System.err.println(path + " is not exist.");
			return;
		}
		try {
			images.put(id, ImageIO.read(new File(path)));
		} catch (Exception e) {
			System.err.println(path);
			throw new RuntimeException(e);
		}
	}
}
