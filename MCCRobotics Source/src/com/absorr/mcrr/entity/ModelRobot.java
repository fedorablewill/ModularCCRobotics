package com.absorr.mcrr.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRobot extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Inventory;
    ModelRenderer Sensor;
    EntityRobot entity;
  
  public ModelRobot(EntityRobot entity)
  {
	  this.entity = entity;
    textureWidth = 256;
    textureHeight = 256;
    
      Base = new ModelRenderer(this, 0, 84);
      Base.addBox(0F, 0F, 0F, (int) entity.width * 16, (int) entity.height * 16, (int) entity.length * 16);
      Base.setRotationPoint(-8F, 0F, -8F);
      Base.setTextureSize(256, 256);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Inventory = new ModelRenderer(this, 0, 109);
      Inventory.addBox(-4F, 0F, 0F, 10, 10, 5);
      Inventory.setRotationPoint(-1F, 4F, 0F);
      Inventory.setTextureSize(256, 256);
      Inventory.mirror = true;
      setRotation(Inventory, 0F, 0F, 0F);
      if (entity.sensors[0] != null)
      {
	      Sensor = new ModelRenderer(this, entity.sensors[0].textureX, entity.sensors[0].textureY);
	      Sensor.addBox(0F, 0F, 0F, 2, 2, 4);
	      Sensor.setRotationPoint(-6F, -2F, -7F);
	      Sensor.setTextureSize(256, 256);
	      Sensor.mirror = true;
	      setRotation(Sensor, 0F, 0F, 0F);
      }
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    Base.render(f5);
    Inventory.render(f5);
    Sensor.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, this.entity);
  }

}
