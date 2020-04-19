package org.elsys.oop.exam1.target;

import org.elsys.oop.exam1.Point;

public class BaseTarget {
    protected Point pos;

    public BaseTarget(Point pos) {
        this.pos = pos;
    }

    public Point getPos() {
        return pos;
    }
}
