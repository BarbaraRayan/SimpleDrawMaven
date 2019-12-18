package View;

import Model.Circle;
import Model.Group;
import Model.Line;
import Model.PolyLine;

public interface ShapeVisitor {
    public abstract void visitor(Group myGroup);
    public abstract void visitor(Line myLine);
    public abstract void visitor(Circle myCircle);
    public abstract void visitor(PolyLine myPolyLine);
    
}
