/*

    Gallardo Morales, Juan Carlos - jcgallardomorales@gmail.com
    Izquierdo Vera, Javier - javieriizquierdovera@gmail.com

 */
package sistemaSolar;

import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.image.TextureLoader;
import java.awt.Color;
import javax.media.j3d.Appearance;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.media.j3d.TransparencyAttributes;

public class OrbitCircle extends BranchGroup{
    
    String archivo_textura = "src/texturas_planetas/orbita.png";
    protected Primitive cilindro;
    protected Appearance apariencia;
 
    protected double radio;
    
    protected Texture textura;
    protected Material material;
    
    public OrbitCircle(Astro astro){
        this.radio = astro.getDistancia();
        cilindro = new Cylinder();
        cilindro.getShape(0).setPickable(false);
        cilindro.getShape(1).setPickable(false);
        cilindro.getShape(2).setPickable(false);
        this.setPickable(false);
    }
    
    public OrbitCircle(double radio, Material material){
        
        this.radio = radio;
        
        setApariencia(material);
    }
    
    public void setApariencia(Material material){
        this.material = material;
        apariencia = new Appearance();
        
        this.textura = new TextureLoader(archivo_textura, null).getTexture();
        TextureAttributes at = new TextureAttributes();
        //at.setTextureMode(TextureAttributes.MODULATE);
        TransparencyAttributes ta = new TransparencyAttributes(TransparencyAttributes.BLENDED,1.0f);
        
        apariencia.setTexture(textura);
        apariencia.setTextureAttributes(at);
        apariencia.setTransparencyAttributes(ta);
        
        apariencia.setMaterial(this.material);
        
        cilindro = new Cylinder((float) (radio), (float) 0.0001, Primitive.GENERATE_TEXTURE_COORDS | Primitive.GENERATE_NORMALS, 500,500, apariencia);
        addChild(cilindro);
    }
    
}
