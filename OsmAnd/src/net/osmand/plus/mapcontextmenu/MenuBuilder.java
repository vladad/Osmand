package net.osmand.plus.mapcontextmenu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.util.Linkify;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.osmand.plus.IconsCache;
import net.osmand.plus.OsmandApplication;
import net.osmand.plus.R;
import net.osmand.plus.render.RenderingIcons;

import java.util.LinkedList;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;

public class MenuBuilder {

	public static final float SHADOW_HEIGHT_TOP_DP = 16f;
	public static final float SHADOW_HEIGHT_BOTTOM_DP = 6f;

	protected OsmandApplication app;
	protected LinkedList<PlainMenuItem> plainMenuItems;
	private boolean firstRow;
	private boolean light;

	public class PlainMenuItem {
		private int iconId;
		private String text;
		private boolean needLinks;

		public PlainMenuItem(int iconId, String text, boolean needLinks) {
			this.iconId = iconId;
			this.text = text;
			this.needLinks = needLinks;
		}

		public int getIconId() {
			return iconId;
		}

		public String getText() {
			return text;
		}

		public boolean isNeedLinks() {
			return needLinks;
		}
	}

	public MenuBuilder(OsmandApplication app) {
		this.app = app;
		plainMenuItems = new LinkedList<>();
		light = app.getSettings().isLightContent();
	}

	public void build(View view) {
		firstRow = true;
		if (needBuildPlainMenuItems()) {
			buildPlainMenuItems(view);
		}
	}

	protected void buildPlainMenuItems(View view) {
		for (PlainMenuItem item : plainMenuItems) {
			buildRow(view, item.getIconId(), item.getText(), 0, item.isNeedLinks(), 0);
		}
	}

	protected boolean needBuildPlainMenuItems() {
		return true;
	}

	protected boolean isFirstRow() {
		return firstRow;
	}

	protected void rowBuilt() {
		firstRow = false;
	}

	protected View buildRow(View view, int iconId, String text, int textColor, boolean needLinks, int textLinesLimit) {
		return buildRow(view, getRowIcon(iconId), text, textColor, needLinks, textLinesLimit);
	}

	protected View buildRow(final View view, Drawable icon, String text, int textColor, boolean needLinks, int textLinesLimit) {
		LinearLayout ll = new LinearLayout(view.getContext());
		ll.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		ll.setLayoutParams(llParams);

		// Icon
		LinearLayout llIcon = new LinearLayout(view.getContext());
		llIcon.setOrientation(LinearLayout.HORIZONTAL);
		llIcon.setLayoutParams(new LinearLayout.LayoutParams(dpToPx(72f), isFirstRow() ? dpToPx(48f) - dpToPx(SHADOW_HEIGHT_BOTTOM_DP) : dpToPx(48f)));
		llIcon.setGravity(Gravity.CENTER_VERTICAL);
		ll.addView(llIcon);

		ImageView iconView = new ImageView(view.getContext());
		LinearLayout.LayoutParams llIconParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
		llIconParams.setMargins(dpToPx(16f), isFirstRow() ? dpToPx(12f) - dpToPx(SHADOW_HEIGHT_BOTTOM_DP / 2f) : dpToPx(12f), dpToPx(32f), dpToPx(12f));
		llIconParams.gravity = Gravity.CENTER_VERTICAL;
		iconView.setLayoutParams(llIconParams);
		iconView.setScaleType(ImageView.ScaleType.CENTER);
		iconView.setImageDrawable(icon);
		llIcon.addView(iconView);

		// Text
		LinearLayout llText = new LinearLayout(view.getContext());
		llText.setOrientation(LinearLayout.VERTICAL);
		ll.addView(llText);

		TextView textView = new TextView(view.getContext());
		LinearLayout.LayoutParams llTextParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		llTextParams.setMargins(0, isFirstRow() ? dpToPx(8f) - dpToPx(SHADOW_HEIGHT_BOTTOM_DP) : dpToPx(8f), 0, dpToPx(8f));
		textView.setLayoutParams(llTextParams);
		textView.setTextSize(16);
		textView.setTextColor(app.getResources().getColor(light ? R.color.ctx_menu_info_text_light : R.color.ctx_menu_info_text_dark));

		if (needLinks) {
			textView.setAutoLinkMask(Linkify.ALL);
			textView.setLinksClickable(true);
		}
		if (textLinesLimit > 0) {
			textView.setMinLines(1);
			textView.setMaxLines(textLinesLimit);
		}
		textView.setText(text);
		if (textColor > 0) {
			textView.setTextColor(view.getResources().getColor(textColor));
		}

		LinearLayout.LayoutParams llTextViewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		llTextViewParams.setMargins(0, 0, dpToPx(10f), 0);
		llTextViewParams.gravity = Gravity.CENTER_VERTICAL;
		llText.setLayoutParams(llTextViewParams);
		llText.addView(textView);

		((LinearLayout) view).addView(ll);

		View horizontalLine = new View(view.getContext());
		LinearLayout.LayoutParams llHorLineParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpToPx(1f));
		llHorLineParams.gravity = Gravity.BOTTOM;
		horizontalLine.setLayoutParams(llHorLineParams);

		horizontalLine.setBackgroundColor(app.getResources().getColor(light ? R.color.ctx_menu_info_divider_light : R.color.ctx_menu_info_divider_dark));

		((LinearLayout) view).addView(horizontalLine);

		rowBuilt();

		return ll;
	}

	protected void buildButtonRow(final View view, Drawable buttonIcon, String text, OnClickListener onClickListener) {
		LinearLayout ll = new LinearLayout(view.getContext());
		ll.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		ll.setLayoutParams(llParams);

		// Empty
		LinearLayout llIcon = new LinearLayout(view.getContext());
		llIcon.setOrientation(LinearLayout.HORIZONTAL);
		llIcon.setLayoutParams(new LinearLayout.LayoutParams(dpToPx(62f), isFirstRow() ? dpToPx(58f) - dpToPx(SHADOW_HEIGHT_BOTTOM_DP) : dpToPx(58f)));
		llIcon.setGravity(Gravity.CENTER_VERTICAL);
		ll.addView(llIcon);


		// Button
		LinearLayout llButton = new LinearLayout(view.getContext());
		llButton.setOrientation(LinearLayout.VERTICAL);
		ll.addView(llButton);

		Button buttonView = new Button(view.getContext());
		buttonView.setBackgroundResource(resolveAttribute(view.getContext(), android.R.attr.selectableItemBackground));
		LinearLayout.LayoutParams llBtnParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		buttonView.setLayoutParams(llBtnParams);
		buttonView.setPadding(dpToPx(10f), 0, dpToPx(10f), 0);
		buttonView.setGravity(Gravity.START | Gravity.CENTER_VERTICAL);
		//buttonView.setTextSize(view.getResources().getDimension(resolveAttribute(view.getContext(), R.dimen.default_desc_text_size)));
		buttonView.setTextColor(view.getResources().getColor(resolveAttribute(view.getContext(), R.attr.contextMenuButtonColor)));
		buttonView.setText(text);

		if (buttonIcon != null) {
			buttonView.setCompoundDrawablesWithIntrinsicBounds(buttonIcon, null, null, null);
			buttonView.setCompoundDrawablePadding(dpToPx(8f));
		}

		buttonView.setOnClickListener(onClickListener);
		llButton.addView(buttonView);

		((LinearLayout) view).addView(ll);

		rowBuilt();
	}

	public void addPlainMenuItem(int iconId, String text, boolean needLinks) {
		plainMenuItems.add(new PlainMenuItem(iconId, text, needLinks));
	}

	public void clearPlainMenuItems() {
		plainMenuItems.clear();
	}

	public Drawable getRowIcon(int iconId) {
		IconsCache iconsCache = app.getIconsCache();
		boolean light = app.getSettings().isLightContent();
		return iconsCache.getIcon(iconId,
				light ? R.color.icon_color : R.color.icon_color_light);
	}

	public Drawable getRowIcon(Context ctx, String fileName) {
		Bitmap iconBitmap = RenderingIcons.getIcon(ctx, fileName, false);
		if (iconBitmap != null) {
			return new BitmapDrawable(ctx.getResources(), iconBitmap);
		} else {
			return null;
		}
	}

	public int resolveAttribute(Context ctx, int attribute) {
		TypedValue outValue = new TypedValue();
		ctx.getTheme().resolveAttribute(attribute, outValue, true);
		return outValue.resourceId;
	}

	public int dpToPx(float dp) {
		Resources r = app.getResources();
		return (int) TypedValue.applyDimension(
				COMPLEX_UNIT_DIP,
				dp,
				r.getDisplayMetrics()
		);
	}
}
