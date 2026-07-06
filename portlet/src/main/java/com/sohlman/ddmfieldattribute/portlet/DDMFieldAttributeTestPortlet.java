package com.sohlman.ddmfieldattribute.portlet;

import com.liferay.dynamic.data.mapping.model.DDMFieldAttribute;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sohlman.ddmfieldattribute.portlet.constants.DDMFieldAttributeTestPortletKeys;
import com.sohlman.ddmfieldattribute.service.DDMFieldAttributeLocalService;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Test portlet to fetch a DDMFieldAttribute by ID, edit its attribute value
 * and save it.
 *
 * @author Sampsa Sohlman
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DDM Field Attribute Test",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DDMFieldAttributeTestPortletKeys.DDM_FIELD_ATTRIBUTE_TEST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0"
	},
	service = Portlet.class
)
public class DDMFieldAttributeTestPortlet extends MVCPortlet {

	@Override
	public void render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws IOException, PortletException {

		long fieldAttributeId = ParamUtil.getLong(
			renderRequest, "fieldAttributeId");

		if (fieldAttributeId > 0) {
			renderRequest.setAttribute(
				"ddmFieldAttribute",
				_ddmFieldAttributeLocalService.fetchByPrimaryKey(
					fieldAttributeId));
		}

		super.render(renderRequest, renderResponse);
	}

	public void saveDDMFieldAttribute(
		ActionRequest actionRequest, ActionResponse actionResponse) {

		long fieldAttributeId = ParamUtil.getLong(
			actionRequest, "fieldAttributeId");

		try {
			DDMFieldAttribute ddmFieldAttribute =
				_ddmFieldAttributeLocalService.findByPrimaryKey(
					fieldAttributeId);

			ddmFieldAttribute.setAttributeValue(
				ParamUtil.getString(actionRequest, "attributeValue"));

			_ddmFieldAttributeLocalService.update(ddmFieldAttribute);

			SessionMessages.add(actionRequest, "ddmFieldAttributeSaved");
		}
		catch (PortalException portalException) {
			SessionErrors.add(
				actionRequest, "ddmFieldAttributeNotFound", portalException);
		}

		actionResponse.getRenderParameters().setValue(
			"fieldAttributeId", String.valueOf(fieldAttributeId));
	}

	@Reference
	private DDMFieldAttributeLocalService _ddmFieldAttributeLocalService;

}
