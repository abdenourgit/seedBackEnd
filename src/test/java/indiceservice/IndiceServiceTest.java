package indiceservice;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bea.core.repackaged.springframework.util.Assert;
import com.seedbackend.service.IndiceService2;

@RunWith(Arquillian.class)
public class IndiceServiceTest {

	    @Inject
	    IndiceService2  indiceService;
	       
	    @Deployment
	    public static JavaArchive createDeployment() {
	        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
	                .addClass(IndiceService2.class)
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	        return jar;
	    }

	    @Test
	    public void cdi_arquillian_test() {
	        Assert.isTrue("KO".equals(indiceService.testString(25)), "Exception sup");
	        Assert.isTrue("OK".equals(indiceService.testString(5)), "Exception inf");
	    }
}
