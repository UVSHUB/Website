document.addEventListener('DOMContentLoaded', () => {

    // Detect which dashboard we are on
    const isClientDashboard = document.getElementById('client-active-jobs') !== null;
    const isFreelancerDashboard = document.getElementById('freelancer-total-earnings') !== null;

    if (isClientDashboard) {
        fetchClientStats();
    } else if (isFreelancerDashboard) {
        fetchFreelancerStats();
    } else {
        // Fallback for generic dashboard if needed
        fetchGenericStats();
    }

    async function fetchClientStats() {
        const API_URL = '/api/dashboard/client';
        try {
            const response = await fetch(API_URL);
            if (!response.ok) throw new Error('Network response was not ok');
            const data = await response.json();

            updateStat('client-active-jobs', data.activeJobs);
            updateStat('client-total-hires', data.totalHires);
            updateStat('client-total-spent', formatCurrency(data.totalSpent));
            updateStat('client-job-views', data.jobViews);

        } catch (error) {
            console.error('Failed to fetch client stats:', error);
        }
    }

    async function fetchFreelancerStats() {
        const API_URL = '/api/dashboard/freelancer';
        try {
            const response = await fetch(API_URL);
            if (!response.ok) throw new Error('Network response was not ok');
            const data = await response.json();

            updateStat('freelancer-total-earnings', formatCurrency(data.totalEarnings));
            updateStat('freelancer-completed-jobs', data.completedJobs);
            updateStat('freelancer-active-jobs', data.activeJobs);
            updateStat('freelancer-rating', data.rating);

        } catch (error) {
            console.error('Failed to fetch freelancer stats:', error);
        }
    }

    async function fetchGenericStats() {
        // Legacy or general stats
        const API_URL = '/api/dashboard/stats';
        try {
            const response = await fetch(API_URL);
            if (!response.ok) return; // Silent fail if generic endpoint not used here
            const data = await response.json();
            // Logic for generic dashboard...
        } catch (error) {
            console.error('Failed to fetch stats:', error);
        }
    }

    function updateStat(elementId, value) {
        const el = document.getElementById(elementId);
        if (el) {
            // Simple animation
            el.style.opacity = '0';
            setTimeout(() => {
                el.textContent = value;
                el.style.opacity = '1';
                el.style.transition = 'opacity 0.3s ease-in';
            }, 100);
        }
    }

    function formatCurrency(value) {
        return new Intl.NumberFormat('en-US', {
            style: 'currency',
            currency: 'USD'
        }).format(value);
    }
});
