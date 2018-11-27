package com.sparta.jas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SetList setList = new SetList();
        setList.setCoreSets();
        System.out.println(setList.getCoreSets());
        setList.setExpertLvExpansions();
        System.out.println(setList.getExpertLvExpansions());
    }
}
