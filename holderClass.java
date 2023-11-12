public class holderClass {
    public int checkObject(Entity entity,boolean player){
        int index = 999;
        for(int i = 0;i< gp.obj.length;i++){
            if(gp.obj[i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.Y = entity.worldY + entity.solidArea.Y;
                gb.obj[i].solidArea.x = gp.obj[i]worldX + gb.obj[i].solidArea.x;
                gb.obj[i].solidArea.y = gp.obj[i]worldY + gb.obj[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            System.out.println("Up collision");
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        System.out.println("Down collision");
                        break;
                    case "right":
                        System.out.println("right collision");
                        entity.solidArea.x += entity.speed;
                        break;
                    case "left":
                        System.out.println("left collision");
                        entity.solidArea.x -= entity.speed;
                        break;
                }

            }
            entity.solidArea.x = entity.solidAreaDefaultX;
            entity.solidArea.y = entity.solidAreaDefaultY;
            gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
            gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
        }
        return index;
    }
}
