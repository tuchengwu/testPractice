package triangle;

/**
 * @author PC
 */
public class Judge {
    public String judge(int x, int y, int z){
        if(isLegalLength(x, y, z)){
            if(isTriangle(x, y, z)){
                if(isEquilateral(x, y, z)){
                    return "等边三角形";
                }
                else if(isIsosceles(x, y, z)){
                    return "等腰三角形";
                }
                else {
                    return "普通三角形";
                }
            }
            else{
                return "不构成三角形";
            }
        }
        else {
            return "含有非正数长度";
        }
    }
    public boolean isLegalLength(int x,int y,int z){
        return x > 0 && y > 0 && z > 0;
    }
    public boolean isTriangle(int x,int y,int z){
        return x + y > z && x + z > y && y + z > x;
    }
    public boolean isEquilateral(int x,int y,int z){
        return x == y && x == z;
    }
    public boolean isIsosceles(int x,int y,int z){
        return x == y || x == z || y == z;
    }
}
