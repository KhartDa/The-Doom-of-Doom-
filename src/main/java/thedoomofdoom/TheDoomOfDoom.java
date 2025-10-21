package thedoomofdoom;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * This is the Main Class of your Game. It should boot up your game and do initial initialisation
 * Move your Logic into AppStates or Controls or other java classes
 */
public class TheDoomOfDoom extends SimpleApplication {

    public static void main(String[] args) {
        
        
        TheDoomOfDoom app = new TheDoomOfDoom();
        app.setShowSettings(false); //Settings dialog not supported on mac
        // app.setResolution(1280, 720);
        
        app.start();
    }

    @Override
    public void simpleInitApp() {

        AppSettings settings = new AppSettings(false);
        settings.setResizable(true);
        settings.setResolution(1280, 720);

        inputManager.deleteMapping(SimpleApplication.INPUT_MAPPING_EXIT);

        flyCam.setDragToRotate(true); // Only rotate when dragging
        inputManager.setCursorVisible(true); // Free the mouse

        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        if (!inputManager.isCursorVisible()) {
            flyCam.setDragToRotate(false);
        }
        else {
            flyCam.setDragToRotate(true);
        }

        //this method will be called every game tick and can be used to make updates
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //add render code here (if any)
    }
}
