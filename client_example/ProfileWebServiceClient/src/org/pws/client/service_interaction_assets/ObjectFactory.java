
package org.pws.client.service_interaction_assets;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.pws.client.service_interaction_assets package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProfileByNickname_QNAME = new QName("http://www.testprofilesstorage.com", "getProfileByNickname");
    private final static QName _RemoveProfileByNicknameResponse_QNAME = new QName("http://www.testprofilesstorage.com", "removeProfileByNicknameResponse");
    private final static QName _EditProfileByNicknameResponse_QNAME = new QName("http://www.testprofilesstorage.com", "editProfileByNicknameResponse");
    private final static QName _AddProfile_QNAME = new QName("http://www.testprofilesstorage.com", "addProfile");
    private final static QName _RemoveProfileByNickname_QNAME = new QName("http://www.testprofilesstorage.com", "removeProfileByNickname");
    private final static QName _Profile_QNAME = new QName("http://www.testprofilesstorage.com", "Profile");
    private final static QName _Result_QNAME = new QName("http://www.testprofilesstorage.com", "Result");
    private final static QName _EditProfileByNickname_QNAME = new QName("http://www.testprofilesstorage.com", "editProfileByNickname");
    private final static QName _AddProfileResponse_QNAME = new QName("http://www.testprofilesstorage.com", "addProfileResponse");
    private final static QName _GetProfileByNicknameResponse_QNAME = new QName("http://www.testprofilesstorage.com", "getProfileByNicknameResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.pws.client.service_interaction_assets
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProfileImpl }
     * 
     */
    public ProfileImpl createProfileImpl() {
        return new ProfileImpl();
    }

    /**
     * Create an instance of {@link ProfileImpl.ProfileInfo }
     * 
     */
    public ProfileImpl.ProfileInfo createProfileImplProfileInfo() {
        return new ProfileImpl.ProfileInfo();
    }

    /**
     * Create an instance of {@link RemoveProfileByNickname }
     * 
     */
    public RemoveProfileByNickname createRemoveProfileByNickname() {
        return new RemoveProfileByNickname();
    }

    /**
     * Create an instance of {@link EditProfileByNicknameResponse }
     * 
     */
    public EditProfileByNicknameResponse createEditProfileByNicknameResponse() {
        return new EditProfileByNicknameResponse();
    }

    /**
     * Create an instance of {@link AddProfile }
     * 
     */
    public AddProfile createAddProfile() {
        return new AddProfile();
    }

    /**
     * Create an instance of {@link GetProfileByNickname }
     * 
     */
    public GetProfileByNickname createGetProfileByNickname() {
        return new GetProfileByNickname();
    }

    /**
     * Create an instance of {@link RemoveProfileByNicknameResponse }
     * 
     */
    public RemoveProfileByNicknameResponse createRemoveProfileByNicknameResponse() {
        return new RemoveProfileByNicknameResponse();
    }

    /**
     * Create an instance of {@link GetProfileByNicknameResponse }
     * 
     */
    public GetProfileByNicknameResponse createGetProfileByNicknameResponse() {
        return new GetProfileByNicknameResponse();
    }

    /**
     * Create an instance of {@link AddProfileResponse }
     * 
     */
    public AddProfileResponse createAddProfileResponse() {
        return new AddProfileResponse();
    }

    /**
     * Create an instance of {@link DefaultResult }
     * 
     */
    public DefaultResult createDefaultResult() {
        return new DefaultResult();
    }

    /**
     * Create an instance of {@link EditProfileByNickname }
     * 
     */
    public EditProfileByNickname createEditProfileByNickname() {
        return new EditProfileByNickname();
    }

    /**
     * Create an instance of {@link ProfileImpl.ProfileInfo.Entry }
     * 
     */
    public ProfileImpl.ProfileInfo.Entry createProfileImplProfileInfoEntry() {
        return new ProfileImpl.ProfileInfo.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProfileByNickname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "getProfileByNickname")
    public JAXBElement<GetProfileByNickname> createGetProfileByNickname(GetProfileByNickname value) {
        return new JAXBElement<GetProfileByNickname>(_GetProfileByNickname_QNAME, GetProfileByNickname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProfileByNicknameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "removeProfileByNicknameResponse")
    public JAXBElement<RemoveProfileByNicknameResponse> createRemoveProfileByNicknameResponse(RemoveProfileByNicknameResponse value) {
        return new JAXBElement<RemoveProfileByNicknameResponse>(_RemoveProfileByNicknameResponse_QNAME, RemoveProfileByNicknameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditProfileByNicknameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "editProfileByNicknameResponse")
    public JAXBElement<EditProfileByNicknameResponse> createEditProfileByNicknameResponse(EditProfileByNicknameResponse value) {
        return new JAXBElement<EditProfileByNicknameResponse>(_EditProfileByNicknameResponse_QNAME, EditProfileByNicknameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "addProfile")
    public JAXBElement<AddProfile> createAddProfile(AddProfile value) {
        return new JAXBElement<AddProfile>(_AddProfile_QNAME, AddProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProfileByNickname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "removeProfileByNickname")
    public JAXBElement<RemoveProfileByNickname> createRemoveProfileByNickname(RemoveProfileByNickname value) {
        return new JAXBElement<RemoveProfileByNickname>(_RemoveProfileByNickname_QNAME, RemoveProfileByNickname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProfileImpl }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "Profile")
    public JAXBElement<ProfileImpl> createProfile(ProfileImpl value) {
        return new JAXBElement<ProfileImpl>(_Profile_QNAME, ProfileImpl.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DefaultResult }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "Result")
    public JAXBElement<DefaultResult> createResult(DefaultResult value) {
        return new JAXBElement<DefaultResult>(_Result_QNAME, DefaultResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EditProfileByNickname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "editProfileByNickname")
    public JAXBElement<EditProfileByNickname> createEditProfileByNickname(EditProfileByNickname value) {
        return new JAXBElement<EditProfileByNickname>(_EditProfileByNickname_QNAME, EditProfileByNickname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddProfileResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "addProfileResponse")
    public JAXBElement<AddProfileResponse> createAddProfileResponse(AddProfileResponse value) {
        return new JAXBElement<AddProfileResponse>(_AddProfileResponse_QNAME, AddProfileResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProfileByNicknameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.testprofilesstorage.com", name = "getProfileByNicknameResponse")
    public JAXBElement<GetProfileByNicknameResponse> createGetProfileByNicknameResponse(GetProfileByNicknameResponse value) {
        return new JAXBElement<GetProfileByNicknameResponse>(_GetProfileByNicknameResponse_QNAME, GetProfileByNicknameResponse.class, null, value);
    }

}
