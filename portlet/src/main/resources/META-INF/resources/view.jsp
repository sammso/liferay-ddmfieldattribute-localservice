<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.dynamic.data.mapping.model.DDMFieldAttribute" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<portlet:defineObjects />

<%
DDMFieldAttribute ddmFieldAttribute = (DDMFieldAttribute)renderRequest.getAttribute("ddmFieldAttribute");

long fieldAttributeId = ParamUtil.getLong(renderRequest, "fieldAttributeId");
%>

<liferay-ui:success key="ddmFieldAttributeSaved" message="the-ddm-field-attribute-was-saved" />
<liferay-ui:error key="ddmFieldAttributeNotFound" message="no-ddm-field-attribute-found-with-the-given-id" />

<portlet:renderURL var="fetchURL" />

<form action="<%= fetchURL %>" method="post">
	<div class="form-group">
		<label for="<portlet:namespace />fieldAttributeId">Field Attribute ID</label>

		<input class="form-control" id="<portlet:namespace />fieldAttributeId" name="<portlet:namespace />fieldAttributeId" type="text" value="<%= (fieldAttributeId > 0) ? String.valueOf(fieldAttributeId) : "" %>" />
	</div>

	<button class="btn btn-primary" type="submit">Fetch</button>
</form>

<% if (ddmFieldAttribute != null) { %>
	<hr />

	<dl>
		<dt>Field Attribute ID</dt>
		<dd><%= ddmFieldAttribute.getFieldAttributeId() %></dd>

		<dt>Field ID</dt>
		<dd><%= ddmFieldAttribute.getFieldId() %></dd>

		<dt>Attribute Name</dt>
		<dd><%= HtmlUtil.escape(ddmFieldAttribute.getAttributeName()) %></dd>

		<dt>Language ID</dt>
		<dd><%= HtmlUtil.escape(ddmFieldAttribute.getLanguageId()) %></dd>
	</dl>

	<portlet:actionURL name="saveDDMFieldAttribute" var="saveURL" />

	<form action="<%= saveURL %>" method="post">
		<input name="<portlet:namespace />fieldAttributeId" type="hidden" value="<%= ddmFieldAttribute.getFieldAttributeId() %>" />

		<div class="form-group">
			<label for="<portlet:namespace />attributeValue">Attribute Value</label>

			<textarea class="form-control" id="<portlet:namespace />attributeValue" name="<portlet:namespace />attributeValue" rows="5"><%= HtmlUtil.escape(ddmFieldAttribute.getAttributeValue()) %></textarea>
		</div>

		<button class="btn btn-primary" type="submit">Save</button>
	</form>
<% } else if (fieldAttributeId > 0) { %>
	<hr />

	<div class="alert alert-warning">No DDM field attribute found with ID <%= fieldAttributeId %>.</div>
<% } %>
