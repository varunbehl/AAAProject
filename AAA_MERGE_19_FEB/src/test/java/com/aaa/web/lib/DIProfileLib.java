package com.aaa.web.lib;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import com.aaa.web.page.DIMCDPage;
import com.aaa.web.page.DIProfilePage;
import com.aaa.web.page.LoginPage;
import com.aaa.accelerators.ActionEngine;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aaa.web.page.CRHomePage;
import com.aaa.web.page.DIHomePage;
import com.aaa.accelerators.ActionEngine;
import com.aaa.web.page.DIMCDPage;
import org.openqa.selenium.Keys;


public class DIProfileLib extends ActionEngine {
    List<WebElement> commentList = new ArrayList<WebElement>();

    List<WebElement> AvailabelSectionColumnNames = null;


    /**
     * Description:To select priority from ID on Profile Window
     * date:29-12-2017
     *
     * @param priority
     * @throws Throwable
     * @author: madhukar
     */
    public void selectPriority(String priority) throws Throwable {
        mouseClick(DIProfilePage.drpdwnPriority, "Select priority");
        selectByValue(DIProfilePage.drpdwnPriority, priority, "Select priority");
        click(DIProfilePage.lblPriority,"Status Label");
    }

    public void selectOrder(String order) throws Throwable {
        mouseClick(DIProfilePage.drpdwnOrder, "Select order");
        selectByVisibleText(DIProfilePage.drpdwnOrder, order, "Select order");
        click(DIProfilePage.lblOrder,"Order Label");
    }

    public void VerifyColumnsMatchingTextAreFilteredDownInAvailabelSection(String filteredtext) throws Throwable {

        String AvailabelSectionColumnNames = getText(DIProfilePage.lblAvailableSectionFilteredColNames, "Available Section Columns Names");

        if (AvailabelSectionColumnNames != null) {
            //for (int i = 0; i <= AvailabelSectionColumnNames.size() - 1; i++) {

                //String ColumNames = AvailabelSectionColumnNames.get(0).getText().toString();
                String colNamesAfterSplit[] = AvailabelSectionColumnNames.split("\\n");
                for (int i = 0; i <= colNamesAfterSplit.length - 1; i++) {

                    /*if (colNamesAfterSplit[i].toLowerCase().contains(filteredtext.toLowerCase())){
                        assertTrue(colNamesAfterSplit[i].toLowerCase().contains(filteredtext.toLowerCase()),"Columns matching the text is filtered down, Filtered Text is "+filteredtext+" Column Name is "+colNamesAfterSplit[i]);
                    }
                    else {
                        assertTrue(colNamesAfterSplit[i].toLowerCase().contains(filteredtext.toLowerCase()),"Columns matching the text is not filtered down, Filtered Text is "+filteredtext+" Column Name is "+colNamesAfterSplit[i]);
                    }*/
                	assertTrue(colNamesAfterSplit[i].toLowerCase().contains(filteredtext.toLowerCase()),"Columns matching the text is filtered down, Filtered Text is "+filteredtext+" Column Name is "+colNamesAfterSplit[i]);
                }
        }

    }
    /**
     * Right Click On Call Is In Prfile window
     * Date:12-02-2018
     * @return
     * rightClickOnOnCallIdOnProfileWindow
     * @throws Throwable
     */
    public void rightClickOnCallIdOnProfileWindow(String callIDAndDate)throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.statusOnPfofile(callIDAndDate),"Right Click On CallId On Profile Tab");
        rightClick(DIProfilePage.statusOnPfofile(callIDAndDate),"Right Click On CallId On Profile Tab");
        Thread.sleep(5000);
    }
    /**
     * Click On Add To Favorites
     * Date:12-02-2018
     * @return
     * clickOnAddToFavorites
     * @throws Throwable
     */
    public void clickOnAddToFavorites(String callIDAndDate)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectLinkFromContextMenu(callIDAndDate),"Click On Add To Favorites ");
        click(DIProfilePage.selectLinkFromContextMenu(callIDAndDate),"Click On Add To Favorites ");
    }
    /**
     * param :: String inputs
     * return ::void
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getRGNFromProfileWindow(String callIDAndDate)throws Throwable{
        waitForVisibilityOfElement(DIProfilePage.getRGNFromProfileWindow(callIDAndDate),"Get RGN Fro Profile");
        String rgn = getText(DIProfilePage.getRGNFromProfileWindow(callIDAndDate),"Get RGN Fro Profile");
        return rgn;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void clickOnRemoveFromFavorites(String callIDAndDate)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectLinkFromContextMenu(callIDAndDate),"Click On Remove From Favorites ");
        click(DIProfilePage.selectLinkFromContextMenu(callIDAndDate),"Click On Remove From Favorites");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void setFavoriteCallFromStatus(String callIDAndDate)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectFavoriteCallFromStatus(callIDAndDate),"Select Favorite call From Status");
        click(DIProfilePage.selectFavoriteCallFromStatus(callIDAndDate),"Select Favorite call From Status ");
    }
    /**
     * param ::
     * return ::String
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public String getFavoriteStatusFromProfile(String callIDAndDate)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectFavoriteCallFromStatus(callIDAndDate),"get Favorite Call status From Profile Window");
        String starStatus = getAttributeByClass(DIProfilePage.selectFavoriteCallFromStatus(callIDAndDate),"get Favorite Call status From Profile Window ");
        return starStatus;
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void mouseHoverOnToComments(String callIDAndDate,String comments)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.mouseHoverToCommentsInContextMenu(callIDAndDate,comments),"Click On Comments ");
        mouseHover(DIProfilePage.mouseHoverToCommentsInContextMenu(callIDAndDate,comments),"Click On Comments ");
        Thread.sleep(3000);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void mouseHoverOntoAutoComment()throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.lblAutocomment,"Auto Comment ");
        mouseHover(DIProfilePage.lblAutocomment,"Auto Comment ");
        Thread.sleep(3000);
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public void selectComment(String autoComment)throws  Throwable{
        waitForVisibilityOfElement(DIProfilePage.selectAutoComment(autoComment),"Auto Comment ");
        click(DIProfilePage.selectAutoComment(autoComment),"Auto Comment ");
    }
    /**
     * param ::
     * return ::void
     * throws :: throwable
     * methodName :: getRGNFromProfileWindow
     * description ::
     * date :: 15-Feb-2018
     * author ::Lakshmi
     */
    public List<String> getCommentsListFromProfile()throws  Throwable{
        List<String> commentsList = new ArrayList<>();

        waitForVisibilityOfElement(DIProfilePage.listOfComments,"Comments List In Profile");
        commentList = getWebElementList(DIProfilePage.listOfComments,"get Comments List From Profile");
        if(commentList!=null){
            for(int i=0;i<commentList.size();i++){
                String comments = commentList.get(i).getText();
                commentsList.add(comments);
            }
        }
        return commentsList;
    }
}
