package org.cerner.multiplex.packageinfo.model;

public class UserRating {

    private int id;
    private String userId;
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    private String name;
    private int rating;
    private int packageId;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPackageId()
    {
        return packageId;
    }

    public void setPackageId(int packageId)
    {
        this.packageId = packageId;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

}
