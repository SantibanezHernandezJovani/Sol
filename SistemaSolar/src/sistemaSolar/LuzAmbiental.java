/*

    Gallardo Morales, Juan Carlos - jcgallardomorales@gmail.com
    Izquierdo Vera, Javier - javieriizquierdovera@gmail.com

 */
package sistemaSolar;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;

public class LuzAmbiental extends BranchGroup{
    public LuzAmbiental(Color3f c){
        AmbientLight luz_ambiental = new AmbientLight();
        luz_ambiental.setColor(c);
        luz_ambiental.setInfluencingBounds(new BoundingSphere(new Point3d(0.0,0.0,0.0),800.0));
        this.addChild(luz_ambiental);
    }
}
