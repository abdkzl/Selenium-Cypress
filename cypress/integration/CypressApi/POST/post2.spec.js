///<reference types="Cypress"/>
//3.plan
const dataJson =require('../../fixtures/createUser.json')

//3.yol utilities file  random email icin
const { generateRandomEmail } = require('../../support/utilities')

describe("post user request",()=>{


    let accessToken ='f422be7713f23b37c718b1da0b74c7b35dda67679073ca466c7c435305ff2a96'
    let randomText=''
    let textEmail=generateRandomEmail
    //2.yol email random email icin
    const myEmail = (Math.random() + 1).toString(36).substring(7) + "@gmail.com";

it('create user test',()=>{

    //1.yol email random email icin
    var pattern="ABCDEFGHLKYPOZYTabcdefgthopma"
    for(var i=0; i<10; i++){
        randomText+=pattern.charAt(Math.floor(Math.random()* pattern.length))
        textEmail=randomText+'@gamil.com'
    }


    cy.request({
        method : 'POST',
        url     :'https://gorest.co.in/public/v2/users',
        headers  :  {
            'authorization' : "Bearer " +accessToken
        },
        body :{
            "name": dataJson.name,
            "email": textEmail,
            "gender": dataJson.gender,
            "status": dataJson.status
        }

    }).then((response)=>{
        expect(response.status).to.eq(201)
        expect(response.body).has.property('email',textEmail)
        expect(response.body).has.property('name',dataJson.name)
        expect(response.body).has.property('gender',dataJson.gender)
        expect(response.body).has.property('status',dataJson.status)

    })
    
   
    
})

})
  
    


