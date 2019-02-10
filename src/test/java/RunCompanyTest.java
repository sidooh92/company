import com.rent.company.domain.RentCompany;
import com.rent.company.service.RentCompanyService;
import com.rent.company.service.RentCompanyServiceImpl;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RunCompanyTest {


    @Test
    public void shouldTestExample()  {
        //given
        //warunki poczatkowe
        RentCompanyService rentCompanyService =  new RentCompanyServiceImpl();
        String name = "Name";
        String website = "website";
        String address = "address";
        String owner = "owner";
        String logo = "logo";
        //when
        //akcja
        RentCompany newCompany = rentCompanyService.createNewCompany(name, website, address, owner, logo);

        //then
       //assercje
        assertThat(newCompany.getName()).isEqualTo("name");
        assertThat(newCompany.getDepartmentList()).isNotNull();

    }



}
