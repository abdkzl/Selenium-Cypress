import { textChangeRangeIsUnchanged } from "typescript";
import LoginPage_WithCredential from "../pages/LoginPage_WithCredential";

describe("Login with credential",()=>{

const loginPage = new LoginPage_WithCredential



it("verify the page name",()=>{

    loginPage.visit()
    loginPage.visitAssertion()
    
    //rgb(118, 118, 118), rgb(133, 133, 133)

})

it.only("Login butonunun uzerine gelindiginde renginin degistigini dogrual",()=>{
    loginPage.visit()
    loginPage.cssAssertion()
})

it("Login wiht valid credential",()=>{

    loginPage.visit()
    loginPage.login()
    


})

it("verify the logged page message and the webpage name",()=>{
    
    loginPage.message()

})

it("Logout from webPage",()=>{
    loginPage.logout()

})

it("verify that logged out from webPage",()=>{

    loginPage.logoutAssertion()
    
})
it("verify that the web page cannot be entered with an invalid password ",()=>{
loginPage.visit()
loginPage.loginInvalidCredentials()

})



}) 








