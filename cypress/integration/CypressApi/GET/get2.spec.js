///<reference types="Cypress"/>

const { updateSpreadAssignment } = require("typescript")


describe("get api users test",()=>{

    // beforeEach(() => {
    //     cy.request('https://gorest.co.in/public-api/users')
    //   })
    let accesToken ='f422be7713f23b37c718b1da0b74c7b35dda67679073ca466c7c435305ff2a96'

    it("get users",()=>{

      cy.request({
          method : 'GET',
          url :'https://gorest.co.in/public-api/users',
          headers : {
              'authorization' :'Bearer f422be7713f23b37c718b1da0b74c7b35dda67679073ca466c7c435305ff2a96'
             
          }
      }).then((response)=>{

        expect(response.status).to.equal(200)

      })


    })
    it.only("get users by id test",()=>{

        cy.request({
            method : 'GET' ,
            url : 'http://gorest.co.in/public-api/users',
            headers : {
                'authorization' : "Bearer"+accesToken,
                'accept': 'application/json'
            },
             body: {   ///username password ile giris istenirse
                 username: 'jane.lane',
                 password: 'password123',
               },

        }).then((response)=>{

        //  expect(response.body.data[0]).to.equal({
        //     "id": '3815',
        //     "name": "Ananda Abbott",
        //     "email": "ananda_abbott@parker-robel.biz",
        //     "gender": "female",
        //     "status": "active"
        // })
           
        //bilgiler anlik degisebilir
        expect(response.body.data[0].name).to.equal('Ananda Abbott')
        expect(response.body.meta.pagination.total).to.equal(3751)
        expect(response.body.code).to.equal(200)

        expect(response.headers.date).to.equal('Mon, 14 Feb 2022 22:10:14 GMT')

  
        })



    })

})